package kz.gnmlab4.hibernate;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class GNM_HIBERNATE {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<UserInfo> criteriaUserInfo = cb.createQuery(UserInfo.class);
        Root<UserInfo> rootUserRole = criteriaUserInfo.from(UserInfo.class);
        //criteriaUserRole.select(rootUserRole);
        criteriaUserInfo.select(rootUserRole).where(cb.like(rootUserRole.get("placeWork"), "%%"));

        CriteriaQuery<Phone_book> criteriaUser = cb.createQuery(Phone_book.class);
        Root<Phone_book> rootUser = criteriaUser.from(Phone_book.class);
        Predicate[] predicates = new Predicate[3];
        predicates[0] = cb.like(rootUser.get("Name_person"), "%Test%");
        predicates[1] = cb.like(rootUser.get("Surname"), "%12%");
        predicates[2] = cb.like(rootUser.get("userInfo").get("placeWork"), "%%");
        criteriaUser.select(rootUser).where(predicates);

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setPlaceWork("PGU");
        userInfo1.setWorkNumber("25789");
        session.save(userInfo1);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPlaceWork("Pgu");
        userInfo2.setWorkNumber("695879");
        session.save(userInfo2);

        org.hibernate.Transaction tr = session.beginTransaction();
        session.delete(userInfo1);
//        session.delete(userRole2);
        tr.commit();

        Phone_book user = new Phone_book();
        user.setName_person("Nikita");
        user.setSurname("Gorbachev");
        user.setMiddleName("Mihaylovych");
        user.setAddress("Panfilova");
        user.setNumber("+7896548");
        user.setUserInfo(new UserInfo("PGU", "22698"));
        session.save(user);

        user = (Phone_book) session.get(Phone_book.class, user.getId());
        user.setName_person("Nikita");
        session.save(user);

        List<Phone_book> resultsUser = session.createQuery(criteriaUser).getResultList();
        resultsUser.forEach((item) -> {
            System.out.println(item);
        });

        List<UserInfo> resultsUserInfo = session.createQuery(criteriaUserInfo).getResultList();
        resultsUserInfo.forEach((item) -> {
            System.out.println(item);
        });

        session.close();

        System.exit(0);
    }

}
