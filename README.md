![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)

# LV3 통합실습 및 결과 제출
# 주제
배달의 민족 마이크로서비스 분석/설계, 구현, 배포/운영

# 서비스 시나리오

기능적 요구사항
- 고객이 메뉴를 선택하여 주문한다.
- 고객이 선택한 메뉴에 대해 결제한다.
- 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다.
- 상점주는 주문을 수락하거나 거절할 수 있다.
- 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다.
- 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다.
- 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다.
- 라이더가 해당 요리를 pick 한후, pick했다고 앱을 통해 통보한다.
- 고객이 주문상태를 중간중간 조회한다.
- 라이더의 배달이 끝나면 배송확인 버튼으로 모든 거래가 완료된다.

이미지

# L3 평가를 위한 체크포인트
# Microservice Implementation
1. Saga (Pub / Sub)
2. CQRS
3. Compensation / Correlation
# Microservice Orchestration
4. Deploy to EKS Cluster
5. Gateway & Service Router 설치
6. Autoscale (HPA)

# 1. Saga (Pub / Sub)
 주문이 완료되면 상점주인에게 주문 내역이 전송된다
 
 ![주문정보](https://user-images.githubusercontent.com/105857882/219085248-a20c38bd-1139-4b59-9b1a-18c7803bcba0.PNG)
 
# 2. CQRS
 주문상태가 주문됨, 주문접수됨, 조리시작됨, 배달시작됨 단계별 진행단계를 확인 할 수 있다
 
![CQRS](https://user-images.githubusercontent.com/105857882/219086004-dd958415-948f-4516-9ad8-45b7c74e6cdc.PNG)

# 3. Compensation / Correlation
  주문을 취소하면 스토어 주문이 취소되고 결재도 취소된다.
  
  ![주문취소](https://user-images.githubusercontent.com/105857882/219088783-a610b8c8-93be-4039-b86e-d569dbe9470d.PNG)


# 4. Deploy to EKS Cluster
  AWS user18-eks Cluster 에 front(앱), store(상점), rider(배달), customer(주문상태) 를 설치한다.



# 5. Gateway & Service Router 설치
  Gateway, 각 Service Router 설치 정보이다.
  


# 6. Autoscale (HPA)
  front(앱)에 대해 autoscale 설정한 상태 정보이다.
  
  siege -c20 -t40S -v http://front:8080/orderLists 를 활용해 autoscale이 동작하는 모습이다.
  
  
