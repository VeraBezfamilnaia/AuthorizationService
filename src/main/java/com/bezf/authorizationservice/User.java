package com.bezf.authorizationservice;

import java.util.List;

public record User(String name, String password, List<Authorities> authorities) { }
