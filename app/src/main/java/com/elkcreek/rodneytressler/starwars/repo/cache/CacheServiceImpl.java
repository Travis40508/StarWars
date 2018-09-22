package com.elkcreek.rodneytressler.starwars.repo.cache;

import com.elkcreek.rodneytressler.starwars.repo.database.DatabaseService;
import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsService;

public class CacheServiceImpl implements CacheService {

    private final StarWarsService network;
    private final DatabaseService database;

    public CacheServiceImpl(StarWarsService network, DatabaseService database) {
        this.network = network;
        this.database = database;
    }
}
