package designpattern.observer;

public interface MySubject {
    void reigsterObserver(MyObserver o);

    void removeObserver(MyObserver o);

    void notifyObserver();
}

