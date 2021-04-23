package music;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Datasource {
	public static final String DB_NAME="music.db";
	public static final String CONNECTION_STRING="jdbc:sqlite:C:\\EclipseWorkspaces\\csse120\\TestDB\\"+DB_NAME;
	public static final String ALBUMS="albums";
	public static final String ARTISTS="artists";
	public static final String SONGS="songs";
	
//
//	public static final String INSERT_ARTIST="insert into artists(name) values(?)";
//	public static final String INSERT_ALBUM="insert into albums(name,artist) values(?,?)";
//	public static final String INSERT_SONG="insert into songs(track,title,album) values(?,?,?)";
//	
//	public static final String QUERY_ARTIST="select _id from artists where name=?";
//	public static final String QUERY_ALBUM="select _id from albums where album=?";
	
	
	public static void main(String[] args) {
		Datasource datasource=new Datasource();
		if(!datasource.open()) {
			System.out.println("cant open datasource");
			return;
		} 
//		List<Artists> artists=datasource.queryArtists(2);
//		if(artists==null) {
//			System.out.println("NO artists");
//			return;
//		}
//		for(Artists artist:artists) {
//			System.out.println("id = "+artist.getId()+", name = "+artist.getName());
//		}
		
//		List<String> albums=datasource.queryAlbumsforArtists("Pink Floyd", 2);
//		if(albums==null) {
//			System.out.println("NO albums");
//			return;
//		}
//		for(String album:albums) {
//			System.out.println("name = "+album);
//		}
		
//		List<SongArtist> artists=datasource.queryArtistsforSong("Heartless", 2);
//		if(artists==null) {
//			System.out.println("NO artists");
//			return;
//		}
//		for(SongArtist artist:artists) {
//			System.out.println("ArtistName = "+artist.getArtistname()+", AlbumName = "+artist.getAlbumname()+", TrackNo = "+artist.getTrack());
//		}
		
		
//		datasource.querySongMetadata();
		
//		int count=datasource.getCount("songs");
//		System.out.println(count);
		
//		datasource.createViewforSongArtists();
//		
//		
//		Scanner scanner=new Scanner(System.in);
//		System.out.println("enter a  song title: ");
//		String title = scanner.nextLine();
		List<SongArtist> artists=datasource.querysongInfoView("Go Your Own Way");
		if(artists.isEmpty()) {
			System.out.println("couldnt find the artists for the song");
			return;
		}
		for(SongArtist artist:artists) {
			System.out.println("ArtistName = "+artist.getArtistname()+", AlbumName = "+artist.getAlbumname()+", TrackNo = "+artist.getTrack());
		}
		
//		datasource.insertsong("Touch of Grey", "Grateful dead", "In The Dark", 1);
		datasource.close();
		
		
		
	}
	private static final String QUERY_SONG_INFO_PREP="select name,album,track from artist_list where title = ?";
	
		private static Connection conn;
		private PreparedStatement querysonginfoview;
		
		
		public boolean open() {
			try {
				conn=DriverManager.getConnection(CONNECTION_STRING);
				querysonginfoview=conn.prepareStatement(QUERY_SONG_INFO_PREP);
				return true;
			} catch (SQLException e) {
				System.out.println("couldnt connect to database: "+e.getMessage());
				e.printStackTrace();
				return false;
			}
		}
		public void close() {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("couldnt close connection: "+e.getMessage());
			}
		}
		
		
		public List<Artists> queryArtists(int sortorder){
			
			StringBuilder sb=new StringBuilder("select * from artists");
			if(sortorder!=1) {
				sb.append(" order by name collate nocase");
				if(sortorder==3){
					sb.append(" desc");
				}
				else {
					sb.append(" asc");
				}
			}
			 
			try(Statement statement=conn.createStatement();
				ResultSet results=statement.executeQuery(sb.toString())) {
							
				List<Artists> artists=new ArrayList<>();
				while(results.next()) {
					Artists artist = new Artists();
					artist.setId(results.getInt(1));
					artist.setName(results.getString(2));
					artists.add(artist);
				}
				results.close();
				statement.close();
				return artists;
				
			} catch (SQLException e) {
				System.out.println("Query failed: "+e.getMessage());
				return null;
			}
		}
		
		public List<String> queryAlbumsforArtists(String artistname,int sortorder){
			StringBuilder sb=new StringBuilder("select albums.name from albums inner join artists on albums.artist=artists._id where artists.name='");
			sb.append(artistname);
			sb.append("'");
			if(sortorder!=1) {
				sb.append(" order by albums.name collate nocase");
				if(sortorder==3){
					sb.append(" desc");
				}
				else {
					sb.append(" asc");
				}
			}
			System.out.println("SQL statement = "+sb.toString());
			try(Statement statement=conn.createStatement();
					ResultSet results=statement.executeQuery(sb.toString())) {
								
					List<String> albums=new ArrayList<>();
					while(results.next()) {
						
						albums.add(results.getString(1));
					}
					results.close();
					statement.close();
					return albums;
					
				} catch (SQLException e) {
					System.out.println("Query failed: "+e.getMessage());
					return null;
				}
			
		}
		
		public List<SongArtist> queryArtistsforSong(String songname,int sortorder){
			StringBuilder sb=new StringBuilder("select artists.name,albums.name,songs.track from songs inner join albums on songs.album=albums._id inner join artists on albums.artist=artists._id where songs.title='");
			sb.append(songname);
			sb.append("'");
			if(sortorder!=1) {
				sb.append(" order by artists.name,albums.name collate nocase");
				if(sortorder==3){
					sb.append(" desc");
				}
				else {
					sb.append(" asc");
				}
			}
			System.out.println("SQL statement = "+sb.toString());
			try(Statement statement=conn.createStatement();
					ResultSet results=statement.executeQuery(sb.toString())) {
								
					List<SongArtist> songArtists=new ArrayList<>();
					while(results.next()) {
						SongArtist songArtist=new SongArtist();
						songArtist.setAlbumname(results.getString(2));
						songArtist.setArtistname(results.getString(1));
						songArtist.setTrack(results.getInt(3));
						
						songArtists.add(songArtist);
					}
					results.close();
					statement.close();
					return songArtists;
					
				} catch (SQLException e) {
					System.out.println("Query failed: "+e.getMessage());
					return null;
				}
			
		}
		
		private void querySongMetadata() {
			String sql="select * from songs";
			try(Statement statement=conn.createStatement();
					ResultSet results=statement.executeQuery(sql)){
				ResultSetMetaData meta=results.getMetaData();
				int numcol=meta.getColumnCount();
				for(int i=1;i<=numcol;i++) {
					System.out.format("column %d in the songs table is named %s\n",i,meta.getColumnName(i));
				}
			}catch (SQLException e) {
				System.out.println("query failed: "+e.getMessage());
			}
		}
		
		public int getCount(String table) {
			String sql="select count(*) as count from "+table;
			try(Statement statement=conn.createStatement();
					ResultSet results=statement.executeQuery(sql)){
				int count=results.getInt("count");
			
				System.out.format("Count=%d\n",count);
				return count;
			}catch (SQLException e) {
				System.out.println("query failed: "+e.getMessage());
				return -1;
			}
		}
		
		public boolean createViewforSongArtists() {
			try(Statement statement=conn.createStatement()){
					statement.execute("create view if not exists artist_list as select artists.name AS name,albums.name AS album,songs.track,songs.title from songs inner join albums on songs.album=albums._id inner join artists on albums.artist=artists._id order by artists.name,albums.name,songs.track collate nocase");
					statement.close();
					return true;
					
				} catch (SQLException e) {
					System.out.println("Query failed: "+e.getMessage());
					return false;
				}
		}
		
//		
		
		public List<SongArtist> querysongInfoView(String title){
//			StringBuilder sb= new StringBuilder("select name,album,track from artist_list where title='");
//			sb.append(title);
//			sb.append("'");
//			System.out.println(sb.toString());
//			
			try {
				querysonginfoview.setString(1, title);
				ResultSet results=querysonginfoview.executeQuery();
					List<SongArtist> songArtists=new ArrayList<SongArtist>();
					while(results.next()) {
						SongArtist songArtist=new SongArtist();
						songArtist.setArtistname(results.getString(1));
						songArtist.setAlbumname(results.getString(2));
						songArtist.setTrack(results.getInt(3));
						songArtists.add(songArtist);
					}
					
					return songArtists;
			} catch (Exception e) {
				System.out.println("query failed: "+e.getMessage());
				return null;
			}
			
//			try(Statement statement=conn.createStatement();
//					ResultSet results=statement.executeQuery(sb.toString())){
//				List<SongArtist> songArtists=new ArrayList<SongArtist>();
//				while(results.next()) {
//					SongArtist songArtist=new SongArtist();
//					songArtist.setArtistname(results.getString(1));
//					songArtist.setAlbumname(results.getString(2));
//					songArtist.setTrack(results.getInt(3));
//					songArtists.add(songArtist);
//				}
//				results.close();
//				statement.close();
//				return songArtists;
//			}catch (SQLException e) {
//				System.out.println("query faied: "+e.getMessage());
//				return null;
//			}
		}
	
		
}
