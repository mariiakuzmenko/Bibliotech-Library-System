package ua.com.kisit.library2026.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.kisit.library2026.entity.Users;
import ua.com.kisit.library2026.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }

    public boolean getUserFromDB(String username) {
        return  usersRepository.findByUsername(username) != null;
    }

    public Users saveUsers(Users users) {
        return usersRepository.save(users);
    }

    public Users findById(Long id) {
        return  usersRepository.findById(id).get();
    }
}
