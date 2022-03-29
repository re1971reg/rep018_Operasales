package ru.dz1;

import ru.dz1.builders.OperaBuilder;
import ru.dz1.builders.OperaChanger;
import ru.dz1.services.OperaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OperasalesApplication {

    public static void main(String[] args) {

        //1) Добавлять новые премьеры (с указанием названия, подробного описания, возрастной категории и количество доступных мест)
        //2) Изменять показатели премьеры
        //3) Удалять мероприятие
        //4) Просматривать список всех мероприятий и какого-то конкретного (с подробным описанием)

        final ConfigurableApplicationContext ctx = SpringApplication.run(OperasalesApplication.class, args);

        OperaService operaService = ctx.getBean(OperaService.class);

        operaService.add(new OperaBuilder().name("Опера#1").description("Описание для Оперы#1").ageCategory("0+").placesCount(100).build());
        operaService.add(new OperaBuilder().name("Опера#2").description("Описание для Оперы#2").ageCategory("10+").placesCount(50).build());
        operaService.add(new OperaBuilder().name("Опера#3").description("Описание для Оперы#3").ageCategory("16+").placesCount(20).build());
        operaService.add(new OperaBuilder().name("Опера#4").description("Описание для Оперы#4").ageCategory("21+").placesCount(10).build());
        System.out.println(operaService.toString());

        System.out.println("************");

        operaService.remove("Опера#2");
        System.out.println(operaService.toString());

        System.out.println("************");
        operaService.change(new OperaChanger().name("Опера#4").description("НОВОЕ Описание для Оперы#4").ageCategory("5+"));
        System.out.println(operaService.toString());

        System.out.println("************");
        operaService.buyTicket("Опера#1", 40);
        operaService.buyTicket("Опера#3", 19);
        System.out.println(operaService.toString());
        operaService.refundTicket("Опера#3", 10);
        System.out.println(operaService.toString());

        System.out.println("************");
        operaService.getOperaByName("Опера#4").toString();
    }
}