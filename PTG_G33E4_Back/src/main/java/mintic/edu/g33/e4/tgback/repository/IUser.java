package mintic.edu.g33.e4.tgback.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mintic.edu.g33.e4.tgback.model.User;

public interface IUser extends CrudRepository<User, Long> {

	@Query("select count(*) from User as p where p.userName=:userName and p.psswrd=:psswrd")
	Integer findByUserNameAndPassword( @Param("userName") String userName,
								@Param("psswrd") String psswrd);
	
	@Query("select p from User as p where p.userName=:userName and p.psswrd=:psswrd")
	User findByNameAndPassword( @Param("userName") String userName,
								@Param("psswrd") String psswrd);
	
}
