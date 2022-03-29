package ru.dz1.services;

import ru.dz1.builders.OperaChanger;
import ru.dz1.model.Opera;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OperaService {

    private final Map<String, Opera> operasData;

    public OperaService() {
        this.operasData = new TreeMap<>();
    }

    public void add(Opera opera) {
        if (operasData.containsKey(opera.getOperaName())) {
            throw new IllegalArgumentException(
                    String.format("Опера с наименование %s уже заведена в список", opera.getOperaName()));
        }
        operasData.put(opera.getOperaName(), opera);
    }

    public void remove(String operaName) {
        if (!operasData.containsKey(operaName)) {
            throw new RuntimeException(
                    String.format("Опера {%s} не найдена в списке, удаление невозможно", operaName));
        }
        operasData.remove(operaName);
    }

    public void buyTicket(String operaName, int ticketCount) {
        if (!operasData.containsKey(operaName)) {
            throw new RuntimeException(
                    String.format("Опера {%s} не найдена в списке доступных для продажи билетов", operaName));
        }
        operasData.get(operaName).buyTikets(ticketCount);
    }

    public void refundTicket(String operaName, int ticketCount) {
        if (!operasData.containsKey(operaName)) {
            throw new RuntimeException(
                    String.format("Опера {%s} не найдена в списке доступных для возврата билетов", operaName));
        }
        operasData.get(operaName).refundTickets(ticketCount);
    }

    public Opera getOperaByName(String operaName) {
        return operasData.get(operaName);
    }

    public void change(OperaChanger operaChanger) {
        if (!operasData.containsKey(operaChanger.getName())) {
            throw new RuntimeException(
                    String.format("Опера {%s} не найдена в списке", operaChanger.getName()));
        }
        operasData.get(operaChanger.getName()).change(operaChanger);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OperaCollections {\n");
        for (Map.Entry opera  : this.operasData.entrySet()) {
            sb.append(opera.toString());
            sb.append('\n');
        }
        sb.append("}");
        return sb.toString();
    }
}