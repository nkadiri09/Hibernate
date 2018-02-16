# Annotations.

@Table(schema="<>", name="<>")  --- You have to sepcify the schema and table name
@Column                         --- For column name
@Transient                      --- to omit this field to create as a column
@Temporal                       --- date representaion
@Lob                            --- large binary object
@Entity                         --- Hibernate will scan that package for any Java objects annotated with the @Entity annotation. If it finds any, 
then it will begin the process of looking through that particular Java object to recreate it as a table in your database

@GeneratedValue(strategy = GenerationType.AUTO) --- to generate auto value for the field like PrimaryKey (surrogate primarykey)
	like autogenerate sequence in Oracle, auto-increment value in MySql.



# Retrive data from table using classname and primarykey

	session = sessionFactory.openSession();
	session.beginTransaction();
 	user = (UserDetails) session.get(UserDetails.class, 1);
 	System.out.println("User we are retriving is: "+user.getUserName());

here we are retriving userdetails table with primarykey 1.
