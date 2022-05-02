package spms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
  String url;
  String username;
  String password;
  ArrayList<Connection> connList = new ArrayList<Connection>();
  
  public DBConnectionPool(String driver, String url, String username, String password) throws Exception {
    this.url = url;
    this.username = username;
    this.password = password;
    
    Class.forName(driver);
  }
  
  public Connection getConnection() throws Exception {
    if (connList.size() > 0) {
      Connection conn = connList.get(0);
      // isValid = 연결 유효성 검사
      // 연결이 유효하면 true, 유효하지 않거나 설정한 시간(현재 10초)이 지나면 false
      if (conn.isValid(10)) {
        return conn;
      }
    }
    // connList에 보관된 객체가 없다면 새로 만들어 반환
    return DriverManager.getConnection(url, username, password);
  }
  
  // 커넥션 객체 사용 후 재사용하기 위해 커넥션풀에 반환
  public void returnConnection(Connection conn) throws Exception {
    connList.add(conn);
  }
  
  // 웹 애플리케이션 종료하기 전 DB와 연동된 자원 모두 종료
  public void closeAll() {
    for(Connection conn : connList) {
      try{conn.close();} catch (Exception e) {}
    }
  }
}
