package com.JES.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.JES.dao.Studentdao;
import com.JES.model.Student;

public class Studentimpl extends HibernateDaoSupport implements Studentdao{
	@SuppressWarnings("unchecked")
	public List<Student> searchStudent(String type,String value){
		String act="from Student s where ";
		switch(type){
		case "ѧԱUID":act+="s.uid=?";return (List<Student>)(getHibernateTemplate().find(act, value));
		case "�û���":act+="s.uname=?";return (List<Student>)(getHibernateTemplate().find(act, value));
		case "��ʵ����":act+="s.name=?";return (List<Student>)(getHibernateTemplate().find(act, value));
		case "�ֻ���":act+="s.phone=?";return (List<Student>)(getHibernateTemplate().find(act, value));
		case "QQ":act+="s.qq=?";return (List<Student>)(getHibernateTemplate().find(act, value));
		case "����":act+="s.email=?";return (List<Student>)(getHibernateTemplate().find(act, value));
		}
		return null;
	}
}
