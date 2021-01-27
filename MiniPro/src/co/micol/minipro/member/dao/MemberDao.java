package co.micol.minipro.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.minipro.common.DAO;
import co.micol.minipro.common.Dbinterface;
import co.micol.minipro.member.service.MemberVo;

public class MemberDao extends DAO implements Dbinterface<MemberVo> {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public ArrayList<MemberVo> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVo select(MemberVo vo) {
		// 한명의 레코드를 찾아오는 메소드
		String sql = "SELECT * FROM MEMBER WHERE MID = ? AND MPASSWORD = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setmName(rs.getString("mname"));
				vo.setmAuth(rs.getString("mauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insert(MemberVo vo) {
		String sql = "INSERT INTO MEMBER(MID, MNAME, MPASSWORD) VALUES(?, ?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmName());
			psmt.setString(3, vo.getmPassword());
			rs = psmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean isIdCheck(String id) {	//id중복체크를 위한 메소드
		boolean bool = true;
		String sql = "SELECT MID FROM MEMBER WHERE MID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				bool = false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return bool;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
