package registrationloginsystem.service.impl;




import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import registrationloginsystem.dto.UserDto;
import registrationloginsystem.entity.Role;
import registrationloginsystem.entity.User;
import registrationloginsystem.repository.RoleRepository;
import registrationloginsystem.repository.UserRepository;
import registrationloginsystem.service.UserService;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public void saveUser(UserDto userDto) {

            User user = new User();
            user.setName(userDto.getFirstName() + " " + userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
    
            Role role = roleRepository.findByName("ROLE_ADMIN");
            if(role == null){
                role = checkRoleExist();
            }
            user.setRoles(Arrays.asList(role));
            userRepository.save(user);
        }
        private Role checkRoleExist(){
            Role role = new Role();
            role.setName("ROLE_ADMIN");
            return roleRepository.save(role);
            
    
    }
        @Override
        public User findUserByEmail(String email) {
           return userRepository.findByEmail(email);
        }
        @Override
        public List<UserDto> findAllUsers() {
            List<User> users = userRepository.findAll();
            return users.stream()
                    .map((user) -> mapToUserDto(user))
                    .collect(Collectors.toList());
        }
    
        private UserDto mapToUserDto(User user){
            UserDto userDto = new UserDto();
            String[] str = user.getName().split(" ");
            userDto.setFirstName(str[0]);
            userDto.setLastName(str[1]);
            userDto.setEmail(user.getEmail());
            return userDto;
        }
    

}