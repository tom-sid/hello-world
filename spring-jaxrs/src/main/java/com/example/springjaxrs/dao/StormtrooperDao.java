package com.example.springjaxrs.dao;

import java.util.Collection;

import com.example.springjaxrs.model.Stormtrooper;

public interface StormtrooperDao {
	Stormtrooper getStormtrooper(String id);

	Stormtrooper addStormtrooper(Stormtrooper stormtrooper);

	Stormtrooper updateStormtrooper(String id, Stormtrooper stormtrooper);

	boolean deleteStormtrooper(String id);

	Collection<Stormtrooper> listStormtroopers();
}
