package com.pokebattle.pokebattleapi.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pokebattle.pokebattleapi.dto.TeamDto;
import com.pokebattle.pokebattleapi.dto.UserDto;
import com.pokebattle.pokebattleapi.exceptions.pokebattle.PokebattleExceptionDto;
import com.pokebattle.pokebattleapi.exceptions.validation.ValidationExceptionDto;
import com.pokebattle.pokebattleapi.form.TeamForm;
import com.pokebattle.pokebattleapi.form.UserForm;
import com.pokebattle.pokebattleapi.model.Team;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User Management")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @Operation(summary = "Register a new user")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "User created successfully", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = UserDto.class)) }),
        @ApiResponse(responseCode = "409", description = "Username already registered", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = PokebattleExceptionDto.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid parameters", 
          content = { @Content(mediaType = "application/json", 
            array = @ArraySchema(schema = @Schema(implementation = ValidationExceptionDto.class))) }) })
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserForm userForm, UriComponentsBuilder uriBuilder) {
        User user = userService.createUser(userForm.getUsername());

        UserDto userDto = new UserDto(user);

        URI uri = uriBuilder.path("/users/{username}").buildAndExpand(user.getUsername()).toUri();

        return ResponseEntity.created(uri).body(userDto);
    }

    @Operation(summary = "Get user information")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Found user information successfully", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = UserDto.class)) }),
        @ApiResponse(responseCode = "404", description = "User not found", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = PokebattleExceptionDto.class)) }) })
    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String username) {
        User user = userService.getUserInfo(username);

        UserDto userDto = new UserDto(user);

        return ResponseEntity.ok(userDto);
    }

    @Operation(summary = "Change a user pokémon team")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Team changed successfully", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = TeamDto.class)) }),
        @ApiResponse(responseCode = "404", description = "User not found", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = PokebattleExceptionDto.class)) }),
        @ApiResponse(responseCode = "404", description = "Pokémon not found", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = PokebattleExceptionDto.class)) }),
        @ApiResponse(responseCode = "409", description = "Repeated pokémon on two or more slots", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = PokebattleExceptionDto.class)) }),
        @ApiResponse(responseCode = "409", description = "User doesn't have all the requested pokémons", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = PokebattleExceptionDto.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid parameters", 
          content = { @Content(mediaType = "application/json", 
            array = @ArraySchema(schema = @Schema(implementation = ValidationExceptionDto.class))) }) })
    @PutMapping("/{username}/team")
    public ResponseEntity<TeamDto> changeUserPokemonTeam(@PathVariable String username, @RequestBody TeamForm teamForm) {
        Team team = userService.changeUserPokemonTeam(username, teamForm);

        TeamDto teamDto = new TeamDto(team);

        return ResponseEntity.ok(teamDto);
    }

}
