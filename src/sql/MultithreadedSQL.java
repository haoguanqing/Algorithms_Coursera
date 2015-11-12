package sql;



import java.sql.*;

public class MultithreadedSQL {
	public static void main(String[] args) throws Exception {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");

		Statement stat = conn.createStatement();
		stat.executeUpdate("drop table if exists people");
		stat.executeUpdate("create table people (name, occupation)");
		conn.close();

		SqlTask tasks[] = {
				new SqlTask("Gandhi", "politics"),
				new SqlTask("Turing", "computers"),
				new SqlTask("Picaso", "artist"),
				new SqlTask("shakespeare", "writer"),
				new SqlTask("tesla", "inventor"),
		};

		System.out.println("Sequential DB access:");

		Thread threads[] = new Thread[tasks.length];
		for(int i = 0; i < tasks.length; i++)
			threads[i] = new Thread(tasks[i]);

		for(int i = 0; i < tasks.length; i++) {
			threads[i].start();
			threads[i].join();
		}

		System.out.println("Concurrent DB access:");

		for(int i = 0; i < tasks.length; i++)
			threads[i] = new Thread(tasks[i]);

		for(int i = 0; i < tasks.length; i++)
			threads[i].start();

		for(int i = 0; i < tasks.length; i++)
			threads[i].join();
	}


	private static class SqlTask implements Runnable {
		String name, occupation;

		public SqlTask(String name, String occupation) {
			this.name = name;
			this.occupation = occupation;
		}

		public void run() {
			Connection conn = null;
			PreparedStatement prep = null;
			long startTime = System.currentTimeMillis();

			try {
				try {
					conn = DriverManager.getConnection("jdbc:sqlite:test.db");
					prep = conn.prepareStatement("insert into people values (?, ?)");

					prep.setString(1, name);
					prep.setString(2, occupation);
					prep.executeUpdate();

					long duration = System.currentTimeMillis() - startTime;
					System.out.println("   SQL Insert completed: " + duration);
				}
				finally {
					if (prep != null) prep.close();
					if (conn != null) conn.close();
				}
			}
			catch(SQLException e) {
				long duration = System.currentTimeMillis() - startTime;
				System.out.print("   SQL Insert failed: " + duration);
				System.out.println(" SQLException: " + e);
			}
		}
	}
}
