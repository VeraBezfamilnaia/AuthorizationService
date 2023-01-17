package com.bezf.authorizationservice.model;

import com.bezf.authorizationservice.Authorities;

import java.util.List;

public record User(String name, String password, List<Authorities> authorities) { }
