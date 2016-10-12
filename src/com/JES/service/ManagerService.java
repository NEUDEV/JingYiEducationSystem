package com.JES.service;

import com.JES.dao.Managerdao;
import com.JES.model.Manager;

public class ManagerService {
	private Managerdao managerdao;

	public Managerdao getManagerdao() {
		return managerdao;
	}

	public void setManagerdao(Managerdao managerdao) {
		this.managerdao = managerdao;
	}

	/**
	 * 是否登陆成功。
	 * @param manager 管理员对象。
	 * @return 是否登陆成功。
	 */
	public boolean isLoginSuccess(Manager manager) {
		if (manager.getMname().equals(managerdao.getMname(manager))
				&& manager.getPassword().equals(managerdao.getPassword(manager))) {
			return true;
		}

		return false;
	}

}
