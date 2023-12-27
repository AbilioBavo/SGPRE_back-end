package com.bavo.SGPRE_backend.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bavo.SGPRE_backend.entities.Address;
import com.bavo.SGPRE_backend.entities.Category;
import com.bavo.SGPRE_backend.entities.Item;
import com.bavo.SGPRE_backend.entities.Order;
import com.bavo.SGPRE_backend.entities.OrderItem;
import com.bavo.SGPRE_backend.entities.User;
import com.bavo.SGPRE_backend.repositories.AddressRepository;
import com.bavo.SGPRE_backend.repositories.CategoryRepository;
import com.bavo.SGPRE_backend.repositories.ItemRepository;
import com.bavo.SGPRE_backend.repositories.OrderItemRepository;
import com.bavo.SGPRE_backend.repositories.OrderRepository;
import com.bavo.SGPRE_backend.repositories.UserRepository;

@Configuration
	@Profile("test")
	public class TestConfig implements CommandLineRunner {

		@Autowired
		private UserRepository userRepository;

		@Autowired
		private OrderRepository orderRepository;

		@Autowired
		private CategoryRepository categoryRepository;
		
		@Autowired
		private ItemRepository itemRepository;

		@Autowired
		private OrderItemRepository orderItemRepository;
		
		@Autowired
		private AddressRepository addressRepository;
		
		@Override
		public void run(String... args) throws Exception {

			Category cat1 = new Category(null, "Electronics");
			Category cat2 = new Category(null, "Books");
			Category cat3 = new Category(null, "Computers");
			
			Item p1 = new Item(null, "Nokia C3", "Nulla eu imperdiet purus. Maecenas ante.", null, 7000.0, "", null, cat3);
			Item p2 = new Item(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", null, 2190.0, "", null, cat3);
			Item p3 = new Item(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", null, 1250.0, "", null, cat3);
			Item p4 = new Item(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", null, 1200.0, "", null, cat3);
			Item p5 = new Item(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", null, 100.99, "", null, cat2);

			categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
			itemRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

			User u1 = new User(null, "Elias Bavo", "eliaseyck@gmail.com", 846836066L, "asdfghjkl");
			User u2= new User(null, "Abilio Bavo", "abiliobavo@gmail.com", 875109441L, "124sad");
			
			Address ads1= new Address(null, "Maputo","Matola" , "Infulene", "Boquisso", "Mercado/Antiga loja", 3, 171);
			addressRepository.saveAll(Arrays.asList(ads1));
			
			Order o1 = new Order(null, Instant.parse("2023-12-27T14:53:07Z"),  ads1, u1);
			Order o2 = new Order(null, Instant.parse("2023-12-27T14:53:07Z"), ads1, u2);
			Order o3 = new Order(null, Instant.parse("2023-12-27T14:53:07Z"), ads1, u1);

			userRepository.saveAll(Arrays.asList(u1, u2));
			orderRepository.saveAll(Arrays.asList(o1, o2, o3));
			
			OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
			OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
			OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
			OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

			orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));	
		}
	}
