package com.balbasio.SpringMovieApp.service;

import com.balbasio.SpringMovieApp.dto.request.LoginRequestDto;
import com.balbasio.SpringMovieApp.dto.request.UserRegisterRequestDto;
import com.balbasio.SpringMovieApp.dto.response.LoginResponseDto;
import com.balbasio.SpringMovieApp.mapper.UserMapper;
import com.balbasio.SpringMovieApp.repository.UserRepository;
import com.balbasio.SpringMovieApp.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements ServiceCrud<User>{
    private final UserRepository repository;

    public User createUser(String name, String surname, String email, String passwprd) {
        User user=User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(passwprd)
                .build();
        return repository.save(user);
    }
    public User register(UserRegisterRequestDto dto){
        User user= User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
        return repository.save(user);
    }
    public List<User> findAllByOrderByName(){
        return repository.findAllByOrderByName();
    }
    public List<User> findAllByNameContainingIgnoreCase(String value){
        return repository.findAllByNameContainingIgnoreCase(value);
    }
    public List<User> findAllByEmailContainingIgnoreCase(String value){
        return repository.findAllByEmailContainingIgnoreCase(value);
    }
    public List<User> findAllByEmailEndingWith(String value){
        return repository.findAllByEmailEndingWith(value);
    }
    public LoginResponseDto login(LoginRequestDto dto){
        Optional<User> user=repository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user.isPresent()){
            return UserMapper.INSTANCE.fromUserToLoginResponseDto(user.get());
        }else{
            throw new RuntimeException("Boyle bir kullanici bulunmamaktadir.");
        }
    }

    public List<User> passwordLongerThan(int value){
        return repository.passwordLongerThan(value);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return repository.saveAll(t);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }
}
