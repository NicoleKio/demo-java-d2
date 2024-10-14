package ua.com.owu.demojavad2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

}

//------------------------------------------------------------

//Аннотация @Controller
//Это помогает Spring определить компоненты, которые будут обрабатывать входящие запросы.В этом случае метод hello()
// обрабатывает запрос на URL /hello и возвращает имя представления ( hello ), которое будет использовано для отображения ответа пользователю.

// Rest -  стиль взаимодействия (обмена данными) между разными компонентами системы,
// каждая из которых может физически располагаться в разных местах.