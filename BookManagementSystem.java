import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class BookManagementSystem {
	public static void main(String args[])throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		   final String url = "jdbc:mysql:///dxc";
		   final String user = "root";
		   final String password = "Password";
		   final String INSERT_book_QUERY = "INSERT INTO book VALUES (?,?,?,?)";
		   
		   Connection con= DriverManager.getConnection(url,user,password);
		   
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter 1 to Add Book");
	 System.out.println("Enter 2 to delete Book");
	 System.out.println("Enter 3 to Show Book");
	 System.out.println("Enter 4 to exit");
	 System.out.println("Enter yor choice");
	 
	 int k =sc.nextInt();
	 
	 if(k==1){
		 
		 
		
	     int n=0;
	     int BookId=0 ;
	     String BookName=null ;
	     String AuthorName=null;
	     int Edition=0;
	     int result=0;
	     PreparedStatement ps = con.prepareStatement(INSERT_book_QUERY);
	     if(sc!=null) {
	    	 System.out.println("Enter number of books to be added");
	    	 n=sc.nextInt();
	     }
	    	 for(int i=0; i<n; i++) {
	    		 System.out.println("\nEnter your choice: "+(i+1));
	    		 System.out.println("\nWelcome to BMS");
	              System.out.print("enter book id: ");
	              BookId = sc.nextInt();
	              
	              System.out.print(" Enter Book Name: ");
	              BookName = sc.next();
	              
	              
	              System.out.println("Enter Edition: ");
	              Edition= sc.nextInt();
	              System.out.print("Enter Author name: ");
	              AuthorName = sc.next();
	              

	              
	              ps.setInt(1, BookId);
	              ps.setString(2,BookName);
	              ps.setString(3, AuthorName);
	              ps.setInt(4, Edition);
	             
	              

	              
	              result = ps.executeUpdate();
	              if(result == 0) {
			           System.out.println("\nBook insertion failed");
			        } else {
			           System.out.println("\nBook inserted successfully.");
			      
			        }
	              
	    	 }
	    	 
	 } else if(k==2) {
		 int result=0;
		 int l=0;
		 System.out.println("Enter the book id to delete the book");
		l=sc.nextInt();
		 try {
			 PreparedStatement ps = con.prepareStatement("DELETE FROM book WHERE BookId = " + l+ "");
			
		     result=   ps.executeUpdate();
		     if(result == 0) {
		           System.out.println("\nBook deletion failed");
		        } else {
		           System.out.println("\nBook deletion successfully.");
		      
		        }
		 }
		 catch(Exception e) {
		        System.out.println(e);
		    }
		 
	 }else if(k==3) {
		 Statement st = con.createStatement();
		 String Query ="SELECT * FROM book ";
		 ResultSet rs = st.executeQuery(Query);
		 boolean flag=false;
		System.out.println("Bookid  "+ "BookName  "+"  AuthorName "+" EDition");
		 while(rs.next()) {
			 flag=true;
			 System.out.println(" "+rs.getInt(1)+"       " +rs.getString(2)+"      " +rs.getString(3)+"            " +rs.getInt(4));
		 }
		 if(flag==true) {
			 System.out.println("\nBooks  diplayed ");
		 }else
			 System.out.println("Books not found");
		 
	 }
	
	 
	     
	    	 else {
	 
		 System.out.println("Thanks for your precious time");
	 
	 
	 }
	 con.close();
	}
}