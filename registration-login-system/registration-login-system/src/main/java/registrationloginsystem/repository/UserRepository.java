package registrationloginsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import registrationloginsystem.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
