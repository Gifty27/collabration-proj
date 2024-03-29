package com.Gowfy.Dao;

import java.util.List;

import com.Gowfy.model.Notification;

public interface NotificationDao {
	void addNotification(Notification notification);
	List<Notification>  getNotificationNotViewed(String email);
	Notification getNotificaiton(int id);
	void updateNotification(int id);

}
