package shiyanlou.test.hibernate.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import shiyanlou.test.hibernate.entity.LicencePlate;
import shiyanlou.test.hibernate.entity.User;

public class UserService {
	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);

	// 增
	public void insertUser() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		User user = new User();
		user.setUsername("王大力");
		user.setPassword("999");
		user.setPhonenum("13735593124");
		user.setIDcard("330726198907285052");
		user.setGranted("0");

		Set<LicencePlate> licPlateSet = new HashSet<LicencePlate>();

		LicencePlate licencePlate = new LicencePlate();
		licencePlate.setLicencePlateNum("浙A11111");
		licPlateSet.add(licencePlate);
		LicencePlate licencePlate2 = new LicencePlate();
		licencePlate2.setLicencePlateNum("浙A22222");
		licPlateSet.add(licencePlate2);
		user.setLicencePlate(licPlateSet);

		session.save(licencePlate);
		session.save(user);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	// 增
	public void insertUser(User user) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		user.setGranted("0");
		session.save(user);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	// 查
	public void searchUser() {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// 利用 StringBuilder 来连接查询语句
		StringBuilder hq = new StringBuilder();

		// 从 User 里面查找（注意 from 后有空格）
		// 相当于 "select * from user_info;"
		hq.append("from ").append(User.class.getName());

		// 利用 session 建立 query
		Query query = session.createQuery(hq.toString());

		// 序列化 query 的结果为一个 list 集合
		List<User> users = query.list();

		// 打印每一个 User 信息（这里只打印了名字，你也可以打印其他信息）
		for (User user : users) {
			System.out.println(user.getUsername());

		}

		/*
		 * User user = new User(); user.setId(3); user.setUsername("user2");
		 * user.setPassword("helloworld");
		 * 
		 * session.save(user);
		 */

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	// 改
	public void updateUser() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		StringBuilder hq = new StringBuilder();

		// 对比查找的操作来看，因为我们需要修改指定 name 的用户密码，后面需要再添加查询条件
		// 注意 from、where 的空格，":name" 表示一个参数
		hq.append("from ").append(User.class.getName())
				.append(" where user_username=:name");

		Query query = session.createQuery(hq.toString());

		// 这里就设定参数 name 的值为"user1"
		query.setString("name", "user1");

		List<User> users = query.list();

		for (User user : users) {

			// 修改 user1 的密码
			user.setPassword("123-user");

			// 注意这里是 update
			session.update(user);
		}

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	// 删
	public void deleteUser() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		StringBuilder hq = new StringBuilder();

		// 对比查找时候的操作来看，因为我们需要修改指定 name 的用户密码，后面需要再添加查询条件
		// 注意 from、where 的空格，":name" 表示一个参数
		hq.append("from ").append(User.class.getName())
				.append(" where user_username=:name");

		Query query = session.createQuery(hq.toString());

		// 这里就设定参数 name 的值为"user1"
		query.setString("name", "user1");

		List<User> users = query.list();

		for (User user : users) {
			// 注意这里是 delete
			session.delete(user);
		}

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	// 普通查询
	public void searchUserbyOrdinary() {
		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		session.beginTransaction();

		// 1. 普通查询
		Query q = session.createQuery("from User as u");

		// 2. 条件查询
		// Query q =
		// session.createQuery(" from User as u where u.username = ?");
		// q.setParameter(0, "Jack");

		// 3. 原生 SQL 查询
		// SQLQuery q =
		// session.createSQLQuery("select * from user_info").addEntity(User.class);

		// 4.criteria 查询
		/*
		 * Criteria q = session.createCriteria(User.class); Criterion cc =
		 * Restrictions.between("id", 1, 3); Criterion cc1 =
		 * Restrictions.idEq(2); q.add(cc); q.add(cc1);
		 */

		List<User> list = q.list();
		for (User e : list) {
			System.out.println(e.getUsername() + ", password: "
					+ e.getPassword());
			// System.out.println( e.getPassword() );
		}

		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	// HQL查询
	public void searchUserbyHQL() {
		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		session.beginTransaction();

		// 1. 普通查询
		// Query q = session.createQuery(" from User as u");

		// 2. 条件查询
		Query q = session.createQuery(" from User as u where u.username = ?");
		q.setParameter(0, "张俊俏");

		// 3. 原生 SQL 查询
		// SQLQuery q =
		// session.createSQLQuery("select * from user_info").addEntity(User.class);

		// 4.criteria 查询
		/*
		 * Criteria q = session.createCriteria(User.class); Criterion cc =
		 * Restrictions.between("id", 1, 3); Criterion cc1 =
		 * Restrictions.idEq(2); q.add(cc); q.add(cc1);
		 */

		List<User> list = q.list();
		for (User e : list) {
			System.out.println(e.getUsername() + ", password: "
					+ e.getPassword());
			// System.out.println( e.getPassword() );
		}

		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	// SQL查询
	public void searchUserbySQL(String username) throws Exception {
		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		session.beginTransaction();

		// 1. 普通查询
		// Query q = session.createQuery(" from User as u");

		// 2. 条件查询
		// Query q =
		// session.createQuery(" from User as u where u.username = ?");
		// q.setParameter(0, "张俊俏");

		// 3. 原生 SQL 查询
		System.out
				.println(("查询！！select * from user_info_byzjq where user_username = " + username));
		SQLQuery q = session.createSQLQuery(
				"select * from user_info_byzjq where username = '" + username
						+ "'").addEntity(User.class);

		// 4.criteria 查询
		/*
		 * Criteria q = session.createCriteria(User.class); Criterion cc =
		 * Restrictions.between("id", 1, 3); Criterion cc1 =
		 * Restrictions.idEq(2); q.add(cc); q.add(cc1);
		 */

		/*
		 * JSONArray json = new JSONArray(); List<User> list = q.list(); for
		 * (User e : list) { System.out.println(e.getUsername() + ", password: "
		 * + e.getPassword()); System.out.println("查查查查查查查查查查查查查查查"); JSONObject
		 * jo = new JSONObject(); jo.put("id", e.getId()); jo.put("username",
		 * e.getUsername()); jo.put("password", e.getPassword()); json.put(jo);
		 * } System.out.println("Output JSON is "+json.toString());
		 */

		if (q.list().isEmpty()) {
			Exception e = new Exception();
			throw e;
		}
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	/**
	 * 
	 * @param 通过查询车牌得到车主信息
	 * @throws Exception
	 */
	public void searchUserbyLicPlateofSQL(String LicPlate) throws Exception {
		/*Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		session.beginTransaction();

		System.out
				.println(("查询語句：select * from licencePlate_table_byzjq where LicencePlateNum = " + LicPlate));
		SQLQuery q = session
				.createSQLQuery(
						"select u.username from user u left join licenceplate l where l.id=5")
				.addEntity(LicencePlate.class);

		if (q.list().isEmpty()) {
			Exception e = new Exception();
			throw e;
		}

		List<LicencePlate> l = q.list();
		for (LicencePlate Le : l) {
			System.out.println();
		}

		session.getTransaction().commit();
		session.close();
		sf.close();*/
	}

	public boolean searchUsergrantedbySQL(String username) {
		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		System.out
				.println(("查询！！select * from user_info_byzjq where username = " + username));
		SQLQuery q = session.createSQLQuery(
				"select * from user_info_byzjq where username = '" + username
						+ "'").addEntity(User.class);

		List<User> list = q.list();
		for (User e : list) {
			System.out.println(e.getUsername() + ", password: "
					+ e.getPassword());
			if (e.getGranted().equals("1")) {
				return true;
			}
		}

		if (q.list().isEmpty()) {
			return false;
		}

		session.getTransaction().commit();
		session.close();
		sf.close();
		return false;
	}

	// criteria 查询
	public void searchUserbyCriteria() {
		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		session.beginTransaction();

		// 1. 普通查询
		// Query q = session.createQuery(" from User as u");

		// 2. 条件查询
		// Query q =
		// session.createQuery(" from User as u where u.username = ?");
		// q.setParameter(0, "张俊俏");

		// 3. 原生 SQL 查询
		// SQLQuery q =
		// session.createSQLQuery("select * from user_info_byzjq").addEntity(User.class);

		// 4.criteria 查询
		Criteria q = session.createCriteria(User.class);
		Criterion cc = Restrictions.between("id", 1, 3);
		Criterion cc1 = Restrictions.idEq(2);
		q.add(cc);
		q.add(cc1);

		List<User> list = q.list();
		for (User e : list) {
			System.out.println(e.getUsername() + ", password: "
					+ e.getPassword());
		}

		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	/*
	 * public void onetoall(){ Configuration cfg = new
	 * Configuration().configure(); SessionFactory sf =
	 * cfg.buildSessionFactory(); Session session = sf.openSession();
	 * session.beginTransaction();
	 * 
	 * // 新建一个 LOL 群组 Group group = new Group();
	 * group.setGroupname("LOL_Group");
	 * 
	 * // 新建两个用户 Set<User> users = new HashSet<User>(); User user1 = new User();
	 * user1.setUsername("令狐冲"); user1.setPassword("555"); User user2 = new
	 * User(); user2.setUsername("令计划"); user2.setPassword("666");
	 * 
	 * users.add(user1); users.add(user2);
	 * 
	 * // LOL 群组包含对应这两个用户 group.setUsers(users);
	 * 
	 * // 保存相关对象 for (User user : users) { session.save(user); }
	 * session.save(group);
	 * 
	 * session.getTransaction().commit(); session.close(); sf.close(); }
	 */
}
