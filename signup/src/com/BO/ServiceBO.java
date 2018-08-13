package com.BO;


public class ServiceBO {
	private int service_id;
	private String service_name;
	private String dt;
	private Double budget;
	
	
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getDt() {
		String[] ab=this.dt.split("-");
		String det =ab[2]+"-"+ab[1]+"-"+ab[0];
		return det;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budget == null) ? 0 : budget.hashCode());
		result = prime * result + ((dt == null) ? 0 : dt.hashCode());
		result = prime * result + (int) (service_id ^ (service_id >>> 32));
		result = prime * result + ((service_name == null) ? 0 : service_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceBO other = (ServiceBO) obj;
		if (budget == null) {
			if (other.budget != null)
				return false;
		} else if (!budget.equals(other.budget))
			return false;
		if (dt == null) {
			if (other.dt != null)
				return false;
		} else if (!dt.equals(other.dt))
			return false;
		if (service_id != other.service_id)
			return false;
		if (service_name == null) {
			if (other.service_name != null)
				return false;
		} else if (!service_name.equals(other.service_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ServiceBO [service_id=" + service_id + ", service_name=" + service_name + ", dt=" + dt + ", budget="
				+ budget + "]";
	}
	
	public ServiceBO(int service_id, String service_name, String dt, Double budget) {
		super();
		this.service_id = service_id;
		this.service_name = service_name;
		String[] ab=dt.split("-");
		
		this.dt = dt;
		this.budget = budget;
	}
	
}
