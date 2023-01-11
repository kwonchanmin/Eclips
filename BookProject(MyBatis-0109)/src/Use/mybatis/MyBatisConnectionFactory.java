package Use.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	private static SqlSessionFactory sqlsessionFactory;

	static {

		String resource = "./SqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);

			if (sqlsessionFactory == null) {
				sqlsessionFactory = new SqlSessionFactoryBuilder().build(reader); // build를 통해서 factory를 만드는 거다.
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlsessionFactory;
	}
}
