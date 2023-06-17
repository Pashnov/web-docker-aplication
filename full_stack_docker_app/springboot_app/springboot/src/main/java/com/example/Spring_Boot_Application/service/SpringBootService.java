package com.example.Spring_Boot_Application.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.Spring_Boot_Application.model.Topic;

@Service
public class SpringBootService {

	private final Map<String, Topic> topicsById = new HashMap<>();
	
	public SpringBootService() {
		topicsById.put("spring", new Topic("spring","springFramework","spring framework is awesome"));
		topicsById.put("java", new Topic("java","core java","java is very best in it's field"));
		topicsById.put("javascript", new Topic("javascript","basic javascript","javascript is so good"));
	}
	
	public Collection<Topic> getAllTopics() {
		return topicsById.values();
	}

	public Topic getTopic(String id) {
		return topicsById.get(id);
	}

	public void addTopic(Topic topic) {
		topicsById.put(topic.getId(), topic);
	}

	public void updateTopic(Topic topic, String id) {
		topicsById.put(id, topic);
	}

	public void deleteTopic(String id) {
		topicsById.remove(id);
	}
	
}
