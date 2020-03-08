# 템플릿 메소드 패턴 (Template Method Pattern)

## ◼︎ 템플릿 메소드 패턴이란?

> 템플릿 메소드 패턴에서는 메소드에서 알고리즘의 골격을 정의합니다.
> 알고리즘의 여러 단꼐 중 일부는 서브 클래스에서 구현할 수 있습니다.
> 템플릿 메소드를 이용하면 알고리즘의 구조는 그대로 유지하면서  
> 서브클래스에서 특정 단계를 재정의할 수 있습니다.

## ◼ 예시 - 패턴 적용 전

> 커피 및 홍차를 만들기 위한 클래스를 만들어보자.
> 아래 코드는 커피를 만들기 위한 `Coffee` 클래스다.
> 각 메소드는 알고리즘의 각 단계를 구현하고 있다.
> 첫 번째는 물을 끓이는 메소드이고
> 두 번째는 커피를 우려내는 메소드,
> 세 번째는 커피를 컵에 따르는 메소드,
> 네 번째는 설탕하고 우유를 집어넣는 메소드다.

```java
public class Coffee { // 커피를 만들기 위한 Coffee 클래스
    void prepareRecipe() { // 커피 만드는 법, 각 단계는 별도의 메소드로 구현
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    public void boilWater() {
        System.out.println("물 끓이는 중");
    }

    public void brewCoffeeGrinds() {
        System.out.println("필터를 통해서 커피를 우려내는 중");
    }

    public void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

    public void addSugarAndMilk() {
        System.out.println("설탕과 우유를 추가하는 중");
    }
}
```

> 아래 코드는 홍차를 만들기 위한 Tea 클래스다.

```java
public class Coffee {
    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    public void boilWater() {
        System.out.println("물 끓이는 중");
    }

    public void steepTeaBag() {
        System.out.println("차를 우려내는 중");
    }

    public void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

    public void addLemon() {
        System.out.println("레몬을 추가하는 중");
    }
}
```

