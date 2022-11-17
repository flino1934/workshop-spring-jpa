package com.lino.course.model.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lino.course.model.entities.enums.OrderStatus;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "clientId")
	private User client;

	// Set para não repetir os pedidos
	// um para muitos, um pedido tem tem muitas ordens de pedido
	@OneToMany(mappedBy = "id.order") // passou id.order pois o id tem tem o order
	private Set<OrderItem> items = new HashSet<>();

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)//estamos mapeando as duas entidades para terem os mesmos id's
	private Payment payment;

	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, Instant moment, User client, OrderStatus status) {
		this.id = id;
		this.moment = moment;
		this.client = client;
		setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public OrderStatus getStatus() {
		return OrderStatus.valueOf(status);
	}

	public void setStatus(OrderStatus status) {

		if (status != null) {
			this.status = status.getCode();
		}

	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Double getTotal() {//começa com get Para sair no Json

		double sum = 0.0;

		for (OrderItem x : items) {
			sum += x.getSubTotal();
		}

		return sum;

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", client=" + client + "]";
	}

}
