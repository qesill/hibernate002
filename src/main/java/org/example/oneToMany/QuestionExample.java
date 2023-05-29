package org.example.oneToMany;

import org.example.Employee;
import org.example.oneToMany.model.Answer;
import org.example.oneToMany.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Question question = new Question("Ile to 5 + 5?");
        Answer a1 = new Answer("8", false);
        Answer a2 = new Answer("11", false);
        Answer a3 = new Answer("10", true);
        Answer a4 = new Answer("12", false);
        List<Answer> answers = new ArrayList<>();
        answers.add(a1);
        answers.add(a2);
        answers.add(a3);
        answers.add(a4);
        question.setAnswers(answers);

        //session.save(question);

        //odczytanie informacji z bazy
        Query query = session.createQuery("FROM Question");
        List<Question> questions = query.list();
        questions.stream().forEach(
                q -> {
                    System.out.println("\n" + q + ":");
                    q.getAnswers().stream().forEach(
                            a -> System.out.println("-" + a));
                }
        );

        Question q2 = new Question("ile jest 4 -4?");
        List<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer("0",true));
        answers2.add(new Answer("1",false));
        q2.setAnswers(answers2);
        session.save(q2);

        transaction.commit();
        sessionFactory.close();
        session.close();
    }
}
