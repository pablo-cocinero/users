package com.company.users.service

import com.company.users.dto.BaseUserDto

import java.time.LocalDateTime;

import com.company.users.dto.UserResponseDto
import com.company.users.exception.UserNotFoundException
import com.company.users.mapper.UserMapper
import com.company.users.model.User
import com.company.users.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification

class UserServiceSpec extends Specification {

    UserRepository userRepository = Mock()
    UserMapper userMapper = Mock()
    PasswordEncoder passwordEncoder = Mock()
    JwtService jwtService = Mock()
    UserService userService = new UserService(userRepository, userMapper, passwordEncoder, jwtService)

    def "signUp should create a new user, save to repository, and return UserResponseDto with token"() {
        given:
        def createUserRequestDto = new BaseUserDto(email: "test@example.com", password: "password123")
        def user = new User(email: createUserRequestDto.email, password: "encodedPassword")
        def savedUser = new User(uuid: "123e4567-e89b-12d3-a456-426614174000", isActive: true, created: LocalDateTime.now(), lastLogin: LocalDateTime.now(), email: "test@example.com")
        def userResponseDto = new UserResponseDto(email: user.email, accessToken: "dummyJwtToken")

        when:
        def result = userService.signUp(createUserRequestDto)

        then:
        1 * userMapper.toEntity(createUserRequestDto) >> user
        1 * passwordEncoder.encode(createUserRequestDto.password) >> "encodedPassword"
        1 * userRepository.save(_) >> savedUser
        1 * userMapper.toResponseDto(savedUser) >> userResponseDto
        1 * jwtService.generateToken(savedUser.email) >> "dummyJwtToken"
        result.email == createUserRequestDto.email
        result.accessToken == "dummyJwtToken"
    }

    def "logIn should return UserResponseDto with generated token when user is found"() {
        given:
        def uuid = "123e4567-e89b-12d3-a456-426614174000"
        def user = new User(uuid: uuid, email: "test@example.com", password: "encodedPassword")
        def userResponseDto = new UserResponseDto(email: user.email)

        when:
        def result = userService.logIn(uuid)

        then:
        1 * userRepository.findByUuid(uuid) >> Optional.of(user)
        1 * userMapper.toResponseDto(user) >> userResponseDto
        1 * jwtService.generateToken(user.email) >> "dummyJwtToken"
        result.email == user.email
        result.accessToken == "dummyJwtToken"
    }

    def "logIn should throw UserNotFoundException when user is not found"() {
        given:
        def uuid = "non-existing-uuid"

        when:
        userService.logIn(uuid)

        then:
        1 * userRepository.findByUuid(uuid) >> Optional.empty()
        thrown(UserNotFoundException)
    }

    def "loadUserByUsername should return UserDetails when user is found"() {
        given:
        def email = "test@example.com"
        def user = new User(email: email, password: "encodedPassword")

        when:
        def result = userService.loadUserByUsername(email)

        then:
        1 * userRepository.findByEmail(email) >> Optional.of(user)
        result.username == email
        result.password == "encodedPassword"
        result.authorities.isEmpty()
    }

    def "loadUserByUsername should throw UsernameNotFoundException when user is not found"() {
        given:
        def email = "non-existing@example.com"

        when:
        userService.loadUserByUsername(email)

        then:
        1 * userRepository.findByEmail(email) >> Optional.empty()
        thrown(UserNotFoundException)
    }
}