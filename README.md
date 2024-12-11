# java-christmas-7

# 기능 목록

## 할인 이벤트

- [ ] 크리스마스 디데이 할인
  - 기간: `2023.12.1 ~ 2023.12.25`
  - `1,000원`으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 `100원`씩 증가
  - 총주문 금액에서 해당 금액만큼 할인  
    (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
- [ ] 평일 할인 (일 ~ 목)
  - 평일에는 `디저트 메뉴`를 메뉴 1개당 `2,023원` 할인
- [ ] 주말 할인 (금요일, 토요일)
  - 주말에는 `메인 메뉴`를 메뉴 1개당 `2,023원` 할인
- [ ] 특별 할인
  - 이벤트 달력에 별이 있으면 총주문 금액에서 `1,000원` 할인
- [ ] 증정 이벤트
  - **할인 전 총주문 금액**이 `12만 원 이상`일 때, `샴페인 1개` 증정
- [ ] 이벤트 기간
  - '크리스마스 디데이 할인'을 제외한 다른 이벤트는 `2023.12.1 ~ 2023.12.31` 동안 적용

## 할인 이벤트 제한 조건

- [ ] 총주문 금액 `10,000원 이상`부터 이벤트가 적용됩니다.
- [x] 음료만 주문 시, 주문할 수 없습니다.
- [x] 메뉴는 한 번에 `최대 20개까지만` 주문할 수 있습니다.  
       (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)

## 배지 이벤트

- [ ] 총 혜택 금액에 따라 배지 부여
  - [x] 5천 원 이상: 별
  - [x] 1만 원 이상: 트리
  - [x] 2만 원 이상: 산타

## 이벤트 혜택 내역 계산

- [ ] 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
- [ ] 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액

## 입출력

### 1. 입력

#### 방문 날짜 입력

- 입/출력

  ```
  12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
  ```

- [x] 1 이상 31 이하의 숫자만 입력한다.

#### 주문 메뉴 및 수량 입력

- 입/출력

  ```
  주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
  ```

- [x] 메뉴의 개수는 1 이상의 숫자만 입력한다.

### 2. 결과 출력

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!

<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개

<할인 전 총주문 금액>
142,000원

<증정 메뉴>
샴페인 1개

<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원

<총혜택 금액>
-31,246원

<할인 후 예상 결제 금액>
135,754원

<12월 이벤트 배지>
산타
```

#### 결과 안내 문구 출력

```
12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
```

- [ ] 결과 안내 문구를 출력한다.

#### 주문 메뉴

```
<주문 메뉴>
타파스 1개
제로콜라 1개
```

- [ ] 주문 내역을 출력한다.

#### 할인 전 총 주문 금액 출력

```
<할인 전 총주문 금액>
8,500원
```

- [ ] 할인 전 총 주문 금액을 계산하여 출력한다.

#### 증정 메뉴

```
<증정 메뉴>
없음
```

- [ ] 증정 메뉴가 존재하는 경우 증정 메뉴 이름을 출력한다.
- [ ] 증정 메뉴가 없는 경우 `없음`으로 출력한다.

#### 혜택 내역

```
<혜택 내역>
없음
```

- [ ] 혜택 내역이 존재하는 경우 혜택 내역을 출력한다.
- [ ] 혜택 내역이 존재하지 않는 경우 `없음`으로 출력한다.

#### 총 혜택 금액

```
<총혜택 금액>
0원
```

- [ ] 총 혜택 금액을 출력한다.

#### 할인 후 예상 결제 금액

```
<할인 후 예상 결제 금액>
8,500원
```

- [ ] 할인 적용 후 예상 결제 금액을 출력한다.

#### 이벤트 배지 출력

```
<12월 이벤트 배지>
없음
```

- [ ] 이벤트 배지를 수령한 경우 이를 출력한다.
- [ ] 이벤트 배지가 존재하지 않는 경우 `없음`을 출력한다.

## 출력 요구사항

- [ ] 에러는 `[ERROR]`를 붙여서 출력한다.

# 예외 처리

- [x] 1 이상 31 이하의 숫자가 아닌 경우, `[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.`라는 에러 메시지를 출력한다.
- [x] 고객이 메뉴판에 없는 메뉴를 입력하는 경우, `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`라는 에러 메시지를 출력한다.
- [x] 메뉴 형식이 예시와 다른 경우, `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`라는 에러 메시지를 출력한다.
- [x] 중복 메뉴를 입력한 경우(e.g. 시저샐러드-1,시저샐러드-1), `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`라는 에러 메시지를 출력한다.
