package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;


import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.DALException;

public class ArticleDaoJdbcImpl {
	private static final String TYPE_STYLO = "STYLO";
	private static final String TYPE_RAMETTE = "RAMETTE";

	private Connection connection = null;

	static {
		// charger le driver jdbc en mémoire
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArticleDaoJdbcImpl() {

	}
	public Connection getConnection() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=PAPETERIE_DB";
		connection = DriverManager.getConnection(url, "sa", "rt");
		return connection;
	}

	public void closeConnection(){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connection=null;
		}
	}

	public void insert(Article a) throws DALException  {
		String sql = "INSERT INTO Articles (reference,marque,designation,prixUnitaire,qteStock,type,grammage,couleur) VALUES ('?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// --- error L'index 1 est hors limites!
			System.out.println(a.getReference());
			stmt.setString(1, a.getReference());
			stmt.setString(2, a.getMarque());
			stmt.setString(3, a.getDesignation());
			stmt.setFloat(4, a.getPrixUnitaire());
			stmt.setInt(5, a.getQteStock());
			if (a instanceof Ramette) {
				Ramette r = (Ramette) a;
				stmt.setString(6, TYPE_RAMETTE);
				stmt.setInt(7, r.getGrammage());
				stmt.setNull(8, Types.VARCHAR);
			}
			if (a instanceof Stylo) {
				Stylo s = (Stylo) a;
				stmt.setString(6, TYPE_STYLO);
				stmt.setNull(7, Types.INTEGER);
				stmt.setString(8, s.getCouleur());
			}
			// ---------------------------
			int result = stmt.executeUpdate();
			// récuperer et set dernière id géneré à l'instance d'Article
			if (result == 1) {
				ResultSet rs = stmt.getGeneratedKeys();
				System.out.println(rs);
				if (rs.next()) {
					a.setIdArticle(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new DALException("Insert article failed - " + a, e);
		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}

			} catch (SQLException e) {
				throw new DALException("close failed - ", e);
			}
			closeConnection();
		}
	}

	public void update(Article a) {

	}
	public Article selectById(int idArticle) {
		return null;
	}

	public List<Article> selectAll() {
		return null;

	}
	public void delete(Article a) {

	}
}
