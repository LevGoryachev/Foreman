package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.BillPositionDAO;
import ru.goryachev.foreman.entities.BillPosition;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.OrderPosition;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillPositionService implements Applicable {

    @Autowired
    public BillPositionDAO billPositionDAO;

    @Autowired
    public OrderPositionService orderPositionService;


    @Override
    public List<BillPosition> getAll() {
        return billPositionDAO.getAll();
    }

    @Override
    public void create(Entity entity) {
        billPositionDAO.create(entity);
    }

    @Override
    public void update(Entity entity) {
        //BillPosition was not supposed to be update for a while
    }

    @Override
    public void delete(int id) {
    }

    //Overloaded. It's better to change delete (int id) delete(int...varargs) later
    public void delete(int construction_id, int material_id) {
        billPositionDAO.delete(construction_id, material_id);
    }

    public List<BillPosition> getByConstruction (int id) {
        return billPositionDAO.getByConstruction(id);
    }

    //the method for fill out ORDER (drop-down list): gets only the billpositions that are not used in current ORDER
    //(if current ORDER already contains these positions (materials) - they should not be available (when filling out ORDER)
    public List<BillPosition> getDeductionOfList (int constructionId, int orderId) {
        List<BillPosition> list = new ArrayList<>();
        boolean ordContains;

        for (BillPosition billPosition : this.getByConstruction(constructionId)) {
            ordContains = false;
            for (OrderPosition orderPosition: orderPositionService.getAll()) {
                if (orderPosition.getOrderid() == orderId && billPosition.getMaterialId() == orderPosition.getMaterialid() && billPosition.getConstructionId() == orderPosition.getConstructionid()) {
                    ordContains = true;
                }
            }
            if (!ordContains) {
                list.add(billPosition);
            }
        }
        return list;
    }
}
