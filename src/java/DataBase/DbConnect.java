package DataBase;
import com.mysql.jdbc.*;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
public class DbConnect {
    private Connection con;
    private PreparedStatement insertUser,checkLogin,getPhoto,SearchPeople,getPeopleByEmail,sendMessage,getMessages,update,
            changePhoto,changePassword,passbyemail,find,unreadmsg,getfilebypid,setstatus;
    public DbConnect() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/people_talk?maxAllowedPacket=96614220","root","Zhatab");
        insertUser=(PreparedStatement) con.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?,?,?)");
        checkLogin = (PreparedStatement) con.prepareStatement("select * from userinfo where email=? and pass=?");
        getPhoto = (PreparedStatement) con.prepareStatement("select photo from userinfo where email=?");
        SearchPeople=(PreparedStatement) con.prepareStatement("select name,email,phone,dob,gender from userinfo where state=? and city=? and email != ? and area like ?");
        getPeopleByEmail=(PreparedStatement) con.prepareStatement("select * from userinfo where email=?");
        sendMessage = (PreparedStatement) con.prepareStatement("insert into peoplemsg  (sid,rid,msg,filename,ufile,udate,status) values (?,?,?,?,?,now(),0)");
        getMessages=(PreparedStatement) con.prepareStatement("select * from peoplemsg where sid=? and rid=? order by udate desc");
        update=(PreparedStatement) con.prepareStatement("update userinfo set name=?,phone=?,gender=?,dob=?,state=?,city=?,area=? where email=?");
        changePhoto=(PreparedStatement)con.prepareStatement("update userinfo set photo=? where email=?");
        changePassword=(PreparedStatement)con.prepareStatement("update userinfo set pass=? where email=? and pass=?");
        passbyemail=(PreparedStatement) con.prepareStatement("select pass from userinfo where email=?");
        find = (PreparedStatement) con.prepareStatement("select name,email,phone,dob,gender from userinfo where email!=? and name like ?");
        unreadmsg=(PreparedStatement) con.prepareStatement("select * from peoplemsg where rid=? and status=0");
        getfilebypid= (PreparedStatement) con.prepareStatement("select ufile from peoplemsg where pid=?");
        setstatus=(PreparedStatement) con.prepareStatement("update peoplemsg set status=? where sid=? and rid=?");
    }
    public String insertUser(HashMap userDetails) throws SQLException{
        try{
            insertUser.setString(1, (String)userDetails.get("email"));
            insertUser.setString(2, (String)userDetails.get("pass"));
            insertUser.setString(3, (String)userDetails.get("name"));
            insertUser.setString(4, (String)userDetails.get("phone"));
            insertUser.setString(5, (String)userDetails.get("gender"));
            insertUser.setDate(6, (java.sql.Date)userDetails.get("dob"));
            insertUser.setString(7, (String)userDetails.get("state"));
            insertUser.setString(8, (String)userDetails.get("city"));
            insertUser.setString(9, (String)userDetails.get("area"));
            insertUser.setBinaryStream(10, (InputStream)userDetails.get("photo"));
            int x=insertUser.executeUpdate();
            if(x!=0)
               return "Success";
            else
                return "Failed";
        }catch(java.sql.SQLIntegrityConstraintViolationException ex){
            return "Already";
        }
    }
    public HashMap checkLogin(String e,String p) throws SQLException{
        checkLogin.setString(1, e);
        checkLogin.setString(2, p);
        ResultSet rs=checkLogin.executeQuery();
        if(rs.next()){
            HashMap userDetails=new HashMap();
            userDetails.put("email", rs.getString("email"));
            userDetails.put("name", rs.getString("name"));
            userDetails.put("phone", rs.getString("phone"));
            userDetails.put("gender", rs.getString("gender"));
            userDetails.put("dob", rs.getDate("dob"));
            userDetails.put("state", rs.getString("state"));
            userDetails.put("city", rs.getString("city"));
            userDetails.put("area", rs.getString("area"));
            return userDetails;
        }else{
            return null;
        }
    }
    public byte[] getPhoto(String email){
        try{
            getPhoto.setString(1, email);
            ResultSet rs = getPhoto.executeQuery();
            if(rs.next()){
                    byte[] b=rs.getBytes("photo") ;
                   if(b.length != 0){
                       return b;
                   }
                   else{
                       return null;
                   }
            }else{
                return null;
            }
        }catch(Exception ex){
            return null;
        }
    }
    public java.util.ArrayList<java.util.HashMap> SearchPeople(String state,String city,String email,String area) throws SQLException{
        SearchPeople.setString(1, state);
        SearchPeople.setString(2, city);
        SearchPeople.setString(3, email);
        SearchPeople.setString(4, "%"+area+"%");
        ResultSet rs= SearchPeople.executeQuery();
        java.util.ArrayList<java.util.HashMap> alluserDetails = new java.util.ArrayList();
        while(rs.next()){
            java.util.HashMap details= new java.util.HashMap();
            details.put("email", rs.getString("email"));
            details.put("name", rs.getString("name"));
            details.put("phone", rs.getString("phone"));
            details.put("gender", rs.getString("gender"));
            details.put("dob", rs.getDate("dob"));
            alluserDetails.add(details);
        }
        return alluserDetails;
    }
    public HashMap getPeopleByEmail(String e) throws SQLException{
        getPeopleByEmail.setString(1,e);
       try{
            ResultSet rs= getPeopleByEmail.executeQuery();
           if(rs.next()){
               HashMap userDetails = new HashMap();
               userDetails.put("email", rs.getString("email"));
                userDetails.put("name", rs.getString("name"));
                userDetails.put("phone", rs.getString("phone"));
                userDetails.put("gender", rs.getString("gender"));
                userDetails.put("dob", rs.getDate("dob"));
                userDetails.put("state", rs.getString("state"));
                userDetails.put("city", rs.getString("city"));
                userDetails.put("area", rs.getString("area"));
                return userDetails;
            }else{
                return null;
            }
        }catch(Exception ex){
            return null;
        }
    }
    public String sendMessage(String s,String r,String msg,String filename,InputStream in) throws SQLException{
        sendMessage.setString(1, s);
        sendMessage.setString(2, r);
        sendMessage.setString(3, msg);
        sendMessage.setString(4, filename);
        sendMessage.setBinaryStream(5, in);
        int x =sendMessage.executeUpdate();
        if(x == 1) return "Done";
        else return "failed";
    }
    public java.util.ArrayList<java.util.HashMap> getMessages(String send,String Rec) throws SQLException{
        getMessages.setString(1,send);
        getMessages.setString(2, Rec);
        ResultSet rs= getMessages.executeQuery();
        java.util.ArrayList<java.util.HashMap> allMessage=new java.util.ArrayList<java.util.HashMap>();
        while(rs.next()){
            java.util.HashMap message=new java.util.HashMap();
            message.put("message",rs.getString("msg"));
            message.put("datetime",rs.getString("udate"));
            message.put("filename",rs.getString("filename"));
            message.put("file",rs.getBytes("ufile"));
            message.put("pid",rs.getString("pid"));
            allMessage.add(message);
        }
        return allMessage;
    }
    public String update(String name,String phone,String gender,java.sql.Date dob,String state,String city,String area,String email) throws SQLException{
        update.setString(1, name);
        update.setString(2, phone);
        update.setString(3, gender);
        update.setDate(4,dob);
        update.setString(5, state);
        update.setString(6, city);
        update.setString(7, area);
        update.setString(8,email);
        int x=update.executeUpdate();
        if(x==1)return "Done";
        else return "Failed";
    }
    public String changePhoto(String email ,InputStream in) throws SQLException{
        changePhoto.setString(2, email);
        changePhoto.setBinaryStream(1, in);
        int x=changePhoto.executeUpdate();
        if(x == 1) return "Done";
        else return "Failed";
    }
    public String changePassword(String n,String e,String o) throws SQLException{
        changePassword.setString(1, n);
        changePassword.setString(2, e);
         changePassword.setString(3, o);
         int x=changePassword.executeUpdate();
         if(x==1){
             return "Done";
         }else{
             return "Failed";
         }
    }
    public String passbyemail(String e) throws SQLException{
        passbyemail.setString(1, e);
        ResultSet rs=passbyemail.executeQuery();
        if(rs.next()){
            return rs.getString("pass");
        }
        else return null;
    }
     public java.util.ArrayList<java.util.HashMap> find(String e,String n) throws SQLException{
         find.setString(1, e);
         find.setString(2,"%"+n+"%");
        ResultSet rs=find.executeQuery();
        java.util.ArrayList<java.util.HashMap> alluserDetails = new java.util.ArrayList();
        while(rs.next()){
            java.util.HashMap details= new java.util.HashMap();
            details.put("email", rs.getString("email"));
            details.put("name", rs.getString("name"));
            details.put("phone", rs.getString("phone"));
            details.put("gender", rs.getString("gender"));
            details.put("dob", rs.getDate("dob"));
            alluserDetails.add(details);
        }
        return alluserDetails;
    }
      public java.util.ArrayList<java.util.HashMap> unreadmsg(String rec) throws SQLException, Exception{
        unreadmsg.setString(1,rec);
        ResultSet rs= unreadmsg.executeQuery();
        java.util.ArrayList<java.util.HashMap> allMessage=new java.util.ArrayList<java.util.HashMap>();
        while(rs.next()){
            java.util.HashMap message=new java.util.HashMap();
            String sid=(String)rs.getString("sid");
            DataBase.DbConnect db = new DataBase.DbConnect();
             message =(HashMap)db.getPeopleByEmail(sid);
             message.put("udate", rs.getString("udate"));
            allMessage.add(message);
        }
        return allMessage;
    }
      public byte[] getfilebypid(int pid) throws SQLException{
          getfilebypid.setInt(1, pid);
          ResultSet rs=getfilebypid.executeQuery();
          if(rs.next()){
              byte b[] = rs.getBytes("ufile");
              if(b.length !=0){ return b;   }
              else{ return null;    }
          }
          else{return null; }
      }
      public void setstatus(int st,String sid,String rid) throws SQLException{
          setstatus.setInt(1, st);
          setstatus.setString(2, sid);
          setstatus.setString(3,rid);
          setstatus.executeUpdate();
      }
}
