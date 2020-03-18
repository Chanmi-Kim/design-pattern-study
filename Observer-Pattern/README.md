### DESIGN PATTERN 01

# 옵저버 패턴 (Observer Pattern)

## ◼︎ 옵저버 패턴이란?

- 신문사와 정기구독자로 이루어지는 신문 구독 서비스에 비유

> 옵저버 패턴(Observer Pattern)에서는 한 객체의 상태가 바뀌면  
> 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이  
> 갱신되는 방식으로 일대다(one-to-many) 의존성을 정의합니다.

- 일대다 관계는 주제와 옵저버에 의해 정의됨
- 옵저버는 주제에 의존함
- 주제의 상태가 바뀌면 옵저버한테 연락이 감
- 연락 방법에 따라 옵저버에 있는 값이 새로운 값으로 갱신될 수 있음
- 옵저버 패턴을 구현하는 방법에는 여러 가지가 있지만, 대부분 주제(Subject) 인터페이스와  
  옵저버(Observer) 인터페이스가 들어있는 클래스 디자인을 바탕으로 

## ◼ 예시 - 패턴 적용 전

> 기상 스테이션용 코드를 짤 때 3가지 디스플레이가 필요한 상황.  
> 기상 관측값이 갱신될 때마다 알려주기 위한 메소드를 사용할 때 공통 인터페이스를 사용하고 있음.  
> 구체적인 구현에 맞춰서 코딩했기 때문에 프로그램을 고치지 않고  
> 다른 디스플레이 항목을 추가하거나 제거하기 불가능. 

```java
    public void measurementsChange() {
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();
    
        // 캡슐화가 필요한 부분
        currentCoditionsDisplay.update(temp, humidity, pressure);
        statisticsDisplay.update(temp, humidity, presure);
        forecastDisplay.update(temp, humidity, pressure);
    }
```

## ◼ 개념

> 신문 구독 메커니즘을 이해하면 옵저버 패턴을 이해할 수 있음.  
> 신문이나 잡지를 구독할 때 출판사와 구독자가 있다고 가정할 때,  
> 출판사를 주제(subject), 구독자를 옵저버(observer)라고 부름.


### 주제(subject)

- 주제 객체에서 일부 데이터 관리
- 주제의 데이터가 달라지면 옵저버한테 전달
- 신문 구독 메커니즘에서 출판사나 신문사

### 옵저버(observer)

- 옵저버 객체들은 주제 객체를 구독하고 있으며(주제 객체에 등록되어 있으며)  
  주제의 데이터가 바뀌면 갱신 내용을 전달 받음
- 신문 구독 메커니즘에서 구독중인 사람  
  
### Duck 객체

- 옵저버가 아니기 때문에 주제 객체의 데이터가 바뀌어도 아무런 데이터도 전달받지 못함
- 신문 구독 메커니즘에서 구독을 해지한 사람

## ◼ 디자인 원칙

> 서로 상호작용을 하는 객체 사이에서는 가능하면 느슨하게 결합하는 디자인을 사용해야 한다.

### 느슨한 결합(Loose Coupling)의 위력

> 두 객체가 느슨하게 결합되어 있다는 것은 그 둘이 상호작용을 하긴 하지만 서로에 대해 서로 잘 모른다는 것을 의미함.
> 옵저버 패턴에서는 주제와 옵저버가 느슨하게 결합되어 있는 객체 디자인을 제공함.

#### 주제가 옵저버에 대해서 아는 것은 옵저버가 특정 인터페이스를 구현한다는 것 뿐임

- 옵저버의 구상 클래스가 무엇인지, 옵저버가 무엇을 하는지 등에 대해서는 알 필요가 없음

#### 옵저버는 언제든지 새로 추가할 수 있음

- 주제는 Observer 인터페이스를 구현하는 객체의 목록에만 의존하기 대문에 언제든지 새로운 옵저버를 추가할 수 있음
- 사실 실행중에 한 옵저버를 다른 옵저버로 바꿔도 되고, 그렇게 해도 주제 객체는 계속해서 데이터를 보낼 수 있음.
- 옵저버를 아무 때나 제거해도 됨

#### 새로운 형식의 옵저버를 추가하려고 할 때도 주제를 전혀 변경할 필요가 없음

- 옵저버가 되어야 하는 새로운 구상 클래스가 생겼다고 가정해보자.
- 이 때도 새로운 클래스 형식을 받아들일 수 있도록 주제를 바꿔야 할 필요는 없음
- 새로운 클래스에서 Observer 인터페이스를 구현하고 옵저버로 등록하기만 하면 됨
- 주제 객체는 전혀 신경도 쓰지 않음
- Observer 인터페이스만 구현한다면 어떤 객체에든지 연락함

#### 주제와 옵저버는 서로 독립적으로 재사용할 수 있음

- 주제나 옵저버를 다른 용도로 활용할 일이 있다고 해도 손쉽게 재사용할 수 있음
- 그 둘이 서로 단단하게 결합되어 있지 않기 때문

#### 주제나 옵저버가 바뀌더라도 서로한테 영향을 미치지 않음

- 둘이 서로 느슨하게 결합되어 있기 때문에 주제 혹은 옵저버 인터페이스를 구현한다는 조건만 만족한다면  
  어떻게 바뀌어도 문제가 생기는 일이 없음

> 느슨하게 결합하는 디자인을 사용하면 변경 사항이 생겨도  
> 무난히 처리할 수 있는 유연한 객체지향 시스템을 구축할 수 있음  
> 객체 사이의 상호의존성을 최소화할 수 있기 때문

## ◼ 예시 - 패턴 적용 

### 기상 스테이션 구현

```java
    public interface Subject {
        public void registerObserver (Observer o); //옵저버를 등록하는 메소드
        public void removeObserver(Observer o); //옵저버를 삭제하는 메소드
        public void notifyObservers(); //상태가 변경될 때 모든 옵저버들한테 알리기 위해 호출되는 메소드
    }
    
    public interface Observer { //모든 옵저버 클래스에서 구현되어야 하는 내용
        //기상 정보가 변경될 때 옵저버한테 전달되는 상태값들을 인자로 전달
        public void update(float temp, float humidity, float pressure);
    }
    
    public interface DisplayElement { //디스플레이 항목을 화면에 표시해야하는 경우 호출하는 메소드
        public void display();
    }
```

### WeatherData에서 Subject 인터페이스 구현하기

```java
    public class WeatherData implements Subject { //Subject 인터페이스 구현
        private ArrayList observers; //Observer 객체를 저장하기 위한 ArrayList, 생성자에서 객체 생성
        private float temperature;
        private float humidity;
        private float pressure;
        
        public WeatherData() {
            observers = new ArrayList(); //객체 생성
        }
        
        public void registerObserver (Observer o) { //옵저버가 등록하면 목록 맨 뒤에 추가
            observers.add(o);
        }
    
        public void removeObserver (Observer o) { //옵저버가 탈퇴를 신청하면 목록에서 제거
            int i = observers.indexOf(o);
            if (i >= 0) {
                observers.remove(i);
            }
        }
        
        public void notifyObservers() { //상태에 대해 모든 옵저버들한테 알려주는 부분
            for (int i=0; i<observers.size(); i++) {
                Observer observer = (Observer) observers.get(i);
                observer.update(temperatre, humidity, pressure);
            }
        }   
        
        public void measurementsChanged() { 
            //기상 스테이션으로부터 갱신된 측정치를 받으면 옵저버들한테 알림
            notifyObservers();
        }   
    
        public void setMeasurements (float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
        }
    
        //기타 WeatherData 메소드
    }
```

### 디스플레이 항목 만들기

```java
    //WeatherData 객체로부터 변경 사항을 받기 위해서 Observer 구현
    //API 구조상 모든 디스플레이 항목에서 DisplayElement를 구현하기로 했기 때문에 DisplayElement 인터페이스도 구현
    public class CurrentConditionsDisplay implements Observer, DisplayElement {
        private float temperature;
        private float humidity;
        private Subject weatherData;
        
        //생성자에 weatherData라는 주제 객체가 전달되며, 그 객체를 써서 디스플레이를 옵저버로 등록
        public CurrentConditionsDisplay(Subject weatherData) {
            this.weatherData = weatherData;
            weatherData.registerObserver(this);
        }
        
        public void update(float temperature, float humidity, float pressure) {
            //해당 메소드가 호출되면 기온과 습도를 저장하고 displ ay 호출됨
            this.temperature = temperature;
            this.humidity = humidity;
            display();
        }    
    
        public void display() {
            //가장 최근에 얻은 기온과 습도를 출력
            System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
        }
    }
```

### 기상 스테이션 돌려보기

```java
    public class WeatherStation {
        public static void main(String[] args) {
            WeatherData weatherData = new WeatherData(); //WeatherData 객체 생성
            
            //디스플레이를 생성하면서 WeatherData 객체를 인자로 전달
            CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
            //StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
            //ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
            
            //새로운 기상 측정값이 들어온 것처럼 만듦
            weatherData.setMeasurements(80, 65, 30.4f);
            weatherData.setMeasurements(82, 70, 29.2f);
            weatherData.setMeasurements(78, 90, 29.2f);
        }
    }
```

## 예제코드

### Observer 인터페이스

```java
/* 추상화된 통보 대상 */
public interface Observer {
  // 데이터 변경을 통보했을 때 처리하는 메서드
  public abstract void update();
}
```

### Subject 인터페이스

```java
/* 추상화된 변경 관심 대상 데이터 */
// 즉, 데이터에 공통적으로 들어가야하는 메서드들 -> 일반화
public abstract class Subject {
  // 추상화된 통보 대상 목록 (즉, 출력 형태에 대한 Observer)
  private List<Observer> observers = new ArrayList<Observer>();

  // 통보 대상(Observer) 추가
  public void attach(Observer observer) { observers.add(observer);}
  // 통보 대상(Observer) 제거
  public void detach(Observer observer) { observers.remove(observer);}
  // 각 통보 대상(Observer)에 변경을 통보. (List<Observer>객체들의 update를 호출)
  public void notifyObservers() {
      for (Observer o : observers) {
          o.update();
      }
  }
}
```

### ScoreRecord 클래스

```java
/* 구체적인 변경 감시 대상 데이터 */
// 출력형태 2개를 가질 때
public class ScoreRecord extends Subject{
  private List<Integer> scores = new ArrayList<Integer>(); // 점수를 저장함
  // 새로운 점수를 추가 (상태 변경)
  public void addScore(int score) {
      scores.add(score); // scores 목록에 주어진 점수를 추가함
      notifyObservers(); // scores가 변경됨을 각 통보 대상(Observer)에게 통보함
  }
  public List<Integer> getScoreRecord() { return scores; }
}
```

### DataSheetView 클래

```java
/* 통보 대상 클래스 (update 메서드 구현) */
// 1. 출력형태: 목록 형태로 출력하는 클래스
public class DataSheetView implements Observer{
  // 위와 동일
}
```

### MinMaxView 클래스

```java
/* 통보 대상 클래스 (update 메서드 구현) */
// 2. 출력형태: 최대값 최소값만 출력하는 클래스
public class MinMaxView implements Observer{
  // 위와 동일
}
```

### 클라이언트에서의 사용

```java
public class Client {
  public static void main(String[] args) {
      ScoreRecord scoreRecord = new ScoreRecord();

      // 3개까지의 점수만 출력함
      DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);
      // 최대값, 최소값만 출력함
      MinMaxView minMaxView = new MinMaxView(scoreRecord);

      // 각 통보 대상 클래스를 Observer로 추가
      scoreRecord.attach(dataSheetView);
      scoreRecord.attach(minMaxView);

      // 10 20 30 40 50을 추가
      for (int index = 1; index <= 5; index++) {
          int score = index * 10;
          System.out.println("Adding " + score);
          // 추가할 때마다 최대 3개의 점수 목록과 최대/최소값이 출력됨
          scoreRecord.addScore(score);
      }
  }
}
```
