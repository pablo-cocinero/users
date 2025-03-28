package com.company.users.service


import spock.lang.Specification
import spock.lang.Subject

class JwtServiceSpec extends Specification {

    @Subject
    JwtService jwtService = new JwtService()

    def email = "user@company.com"

    def "should generate a valid JWT token for given email"() {
        when: "a token is generated"
        def token = jwtService.generateToken(email)

        then: "token should not be null or empty"
        token
        !token.isEmpty()
    }

    def "should extract username correctly from token"() {
        given: "a generated token from an email"
        def token = jwtService.generateToken(email)

        when: "the username is extracted from the token"
        def extractedUsername = jwtService.extractUsername(token)

        then: "the extracted username matches the email"
        extractedUsername == email
    }

    def "should validate token successfully"() {
        given: "a token generated for an email"
        def token = jwtService.generateToken(email)

        when: "the token is validated"
        def isValid = jwtService.validateToken(token)

        then: "the token is valid"
        isValid
    }

    def "should fail validation if token is manipulated"() {
        given: "a valid token"
        def token = jwtService.generateToken(email)

        and: "token is manipulated (e.g., adding extra string at the end)"
        def manipulatedToken = token + "tamperedData"

        when: "validating manipulated token"
        def result = jwtService.validateToken(manipulatedToken)

        then: "the validation should fail"
        thrown(Exception)
        !result
    }
}