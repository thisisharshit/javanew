package music;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecords {
	

	public static final String DB_NAME="music.db";
	public static final String CONNECTION_STRING="jdbc:sqlite:C:\\EclipseWorkspaces\\csse120\\TestDB\\"+DB_NAME;
	public static final String ALBUMS="albums";
	public static final String ARTISTS="artists";
	public static final String SONGS="songs";
	
	public static final String INSERT_ARTIST="insert into artists(name) values(?)";
	public static final String INSERT_ALBUM="insert into albums(name, artist) values(?, ?)";
	public static final String INSERT_SONG="insert into songs(track, title, album) values(?, ?, ?)";
	
	public static final String QUERY_ARTIST="select _id from artists where name = ? ";
	public static final String QUERY_ALBUM="select _id from albums where name = ? ";
	 
	
	public static void main(String[] args) {
		InsertRecords insertRecords=new InsertRecords();
		if(!insertRecords.open()) {
			System.out.println("cant open insertrecords");
			return;
		}
		
		
//		insertRecords.insertsong("Touch of Grey","Grateful Dead", "In The Dark", 1);
		insertRecords.insertsong("Like A Rolling Stone","Bob Dylan", "Bob Dylan's Greatest Hits", 1);
		insertRecords.close();
		
	}
	
	private static Connection conn;
	
	private PreparedStatement insertintoartists;
	private PreparedStatement insertintoalbums;
	private PreparedStatement insertintosongs;
	
	private PreparedStatement queryartist;
	private PreparedStatement queryalbum;
	public boolean open() {
		try {
			conn=DriverManager.getConnection(CONNECTION_STRING);
			insertintoartists=conn.prepareStatement(INSERT_ARTIST,Statement.RETURN_GENERATED_KEYS);
			insertintoalbums=conn.prepareStatement(INSERT_ALBUM,Statement.RETURN_GENERATED_KEYS);
			insertintosongs=conn.prepareStatement(INSERT_SONG);
			queryartist=conn.prepareStatement(QUERY_ARTIST);
			queryalbum=conn.prepareStatement(QUERY_ALBUM);
			return true;
		} catch (SQLException e) {
			System.out.println("couldnt connect to database: "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public void close() {
		try {
			if(insertintoalbums!=null) insertintoalbums.close();
			if(insertintoartists!=null) insertintoartists.close();
			if(insertintosongs!=null) insertintosongs.close();
			if(queryalbum!=null) queryalbum.close();
			if(queryartist!=null) queryartist.close();
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("couldnt close connection: "+e.getMessage());
		}
	}
	
	private int insertartist(String name) throws SQLException{
		queryartist.setString(1, name);
		ResultSet results=queryartist.executeQuery();
		if(results.next()) {
			return results.getInt(1);
		}else {
			insertintoartists.setString(1, name);
			int affectedrows=insertintoartists.executeUpdate();
			if(affectedrows!=1) throw new SQLException("couldnot insert artist");
			
			ResultSet generatedkeys=insertintoartists.getGeneratedKeys();
			if(generatedkeys.next()) {
				return generatedkeys.getInt(1);
			}else {
				throw new SQLException("couldnot get _id for artist");
			}
		}
	}
	
	private int insertalbum(String name,int artistid) throws SQLException{
		
		queryalbum.setString(1,name);
		ResultSet results=queryalbum.executeQuery();
		if(results.next()) {
			return results.getInt(1);
		}else {
			insertintoalbums.setString(1, name);
			insertintoalbums.setInt(2, artistid);
			int affectedrows=insertintoalbums.executeUpdate();
			if(affectedrows!=1) throw new SQLException("couldnot insert album");
			
			ResultSet generatedkeys=insertintoalbums.getGeneratedKeys();
			if(generatedkeys.next()) {
				return generatedkeys.getInt(1);
			}else {
				throw new SQLException("couldnot get _id for album");
			}
		}
	}
	
	private void insertsong(String title,String artist,String album, int track){
		try {
			conn.setAutoCommit(false);
			int artistid=insertartist(artist);
			int albumid=insertalbum(album, artistid);
				
			insertintosongs.setInt(1, track);
			insertintosongs.setString(2, title);
			insertintosongs.setInt(3, albumid);
			int affectedrows=insertintosongs.executeUpdate();
			if(affectedrows==1) conn.commit();
			else throw new SQLException("song insert failed");
			
		} catch (Exception e) {
			System.out.println("insert song excception: "+e.getMessage());
			try {
				System.out.println("preforming rollback");
				conn.rollback();
			} catch (SQLException e2) {
				System.out.println("things are really bad"+e.getMessage());
			}
		}finally {
			try {
				System.out.println("resetting auto commit behaviour");
				conn.setAutoCommit(true);
			} catch (SQLException e2) {
				System.out.println("coulldnot reset auto commit: "+e2.getMessage());
			}
		}
		
	}
	
	
	
}
