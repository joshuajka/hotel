package br.ufg.inf.fs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs.exceptions.QuartoException;

public class QuartoDao {
	Connection conn;
	
	public QuartoDao(Connection conn) {
		this.conn = conn;
	}
	
	public List<Quarto> findAll() throws QuartoException{
		
		List<Quarto> retorno = new ArrayList<Quarto>();
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			String sql = "SELECT id_quarto, id_hotel, categoria_quarto, qtd_leito, nr_quarto, preco_diaria FROM tb_quarto; ";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				Quarto quarto = new Quarto(
						rs.getInt("id_quarto"), 
						new Hotel(rs.getInt("id_hotel"), null, null, null), 
						CategoriaQuarto.get(rs.getInt("categoria_quarto")), 
						rs.getInt("qtd_leito"),
						rs.getInt("nr_quarto"),
						rs.getDouble("preco_diaria"));

				retorno.add(quarto);
			}
		}catch (SQLException e) {
			throw new QuartoException("Erro no banco de dados: "+e.getMessage());
		}finally {
			DB.closeStatment(st);
			DB.closeResultSet(rs);
		}
		return retorno;
	}
	
	public Quarto findById(Integer id) throws QuartoException{
		
		Quarto retorno = new Quarto();
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			
			String sql = "SELECT id_quarto, id_hotel, categoria_quarto, qtd_leito, nr_quarto, preco_diaria FROM tb_quarto WHERE id_quarto = "+id;
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				retorno = new Quarto(
					rs.getInt("id_quarto"), 
					new Hotel(rs.getInt("id_hotel"), null, null, null), 
					CategoriaQuarto.get(rs.getInt("categoria_quarto")), 
					rs.getInt("qtd_leito"),
					rs.getInt("nr_quarto"),
					rs.getDouble("preco_diaria"));
			}
		}catch (SQLException e) {
			throw new QuartoException("Erro no banco de dados: "+e.getMessage());
		}finally {
			DB.closeStatment(st);
			DB.closeResultSet(rs);
		}
		return retorno;
	}
	
public Quarto insert(Quarto quarto) throws QuartoException {
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(" "
					+ "INSERT INTO tb_quarto "
					+ "(id_hotel, categoria_quarto, qtd_leito, nr_quarto, preco_diaria ) "
					+ "VALUES (?, ?, ?, ?, ?)",
			Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, quarto.getHotel().getIdHotel());
			st.setInt(2, quarto.getCategoriaQuarto().getId());
			st.setInt(3, quarto.getQtdLeito());
			st.setInt(4, quarto.getNrQuarto());
			st.setDouble(5, quarto.getPrDiaria());
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					quarto.setIdQuarto(rs.getInt(1));
				}
			}else {
				throw new QuartoException("Ação inesperada! Nenhuma linha foi inserida.");
			}
		}
		catch (SQLException e) {
			throw new QuartoException("Erro no banco de dados: "+e.getMessage());
		}finally {
			DB.closeStatment(st);
		}
		return quarto;
	}

	public Quarto update(Quarto quarto) throws QuartoException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(" "
					+ "UPDATE tb_quarto "
					+ "SET id_hotel = ?, categoria_quarto = ?, qtd_leito = ?, nr_quarto = ?, preco_diaria = ? "
					+ "WHERE id_quarto = ? ");
			
			st.setInt(1, quarto.getHotel().getIdHotel());
			st.setInt(2, quarto.getCategoriaQuarto().getId());
			st.setInt(3, quarto.getQtdLeito());
			st.setInt(4, quarto.getNrQuarto());
			st.setDouble(5, quarto.getPrDiaria());
			st.setInt(6, quarto.getIdQuarto());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new QuartoException("Erro no banco de dados: "+e.getMessage());
		}finally {
			DB.closeStatment(st);
		}
		return quarto;
	}
	
	
	public void delete(Integer id) throws QuartoException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM tb_quarto WHERE id_quarto = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new QuartoException("Erro no banco de dados: "+e.getMessage());
		} 
		finally {
			DB.closeStatment(st);
		}
	}
}
