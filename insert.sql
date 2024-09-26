-- create table
create table lecture
(
    lecture_id  bigint auto_increment
        primary key,
    image_url   varchar(255) null,
    instructor  varchar(255) null,
    goals       text         null,
    target      text         null,
    title       varchar(255) null,
    lecture_url varchar(255) null,
    price       int          null
);

create table member
(
    member_id bigint auto_increment
        primary key,
    email     varchar(255) null,
    name      varchar(255) null,
    password  varchar(255) null,
    role      varchar(255) null
);

create table my_lecture
(
    id         bigint auto_increment
        primary key,
    lecture_id bigint null,
    member_id  bigint null,
    constraint fk_my_lecture_lecture
        foreign key (lecture_id) references lecture (lecture_id),
    constraint fk_my_lecture_member
        foreign key (member_id) references member (member_id)
);



-- member
INSERT INTO member (member_id, email, name, password, role) VALUES (1, 'koo@naver.com', 'koo', '1234', 'ROLE_MEMBER');

-- lecture
INSERT INTO lecture (lecture_id, image_url, instructor, goals, target, title, lecture_url, price) VALUES (1, 'https://cdn.inflearn.com/public/courses/334289/cover/b8885796-1e67-4983-9432-bcda0daae927/334289.png?w=420', '화이트박스', 'Python과 PyTorch로 실제 논문을 읽어보며 구현 해보기|Neural Style Transfer 논문을 이해하기|AI 논문을 읽을 때 알아두면 좋은 팁|논문 구현 경험을 통해 실무 능력을 강화하는 방법|논문 구현 과정에서 발생할 수 있는 문제 해결 방법들', 'AI 커리어에 관심 있는 모든 분들|AI 대학원을 준비 중이신 분들|논문을 읽고 이해하기가 막막 했었던 분들|단순 기본기능 구현 이상의 실무 경험을 쌓고자 하시는 분들', '[AI 실무] AI Research Engineer를 위한 논문 구현 시작하기 with PyTorch', 'https://www.inflearn.com/course/ai-%EB%85%BC%EB%AC%B8%EA%B5%AC%ED%98%84-pytorch?attributionToken=ChIyOTYxMzkyNTM3MzQ1NDg0MDYQDRojcmVjb21tZW5kZV9yZWNvbW1lbmRlXzE3MDI1MjY0MzQwNjYiF3JlY29tbWVuZGVkLWZvci15b3UtY3ZyKAA6KPrx0RK08dESsvHREr7y0RKp8tES9_HREozy0RKP8t', 38500);
INSERT INTO lecture (lecture_id, image_url, instructor, goals, target, title, lecture_url, price) VALUES (2, 'https://cdn.inflearn.com/public/courses/333250/cover/e3f951fc-a1d7-4de4-a065-85bb507b737f/333250.png?w=420', '이정환 Winterlood', '최신 Next.js(v15 이상) 개념에 대해 살펴봅니다.|Page Router부터 App Router까지 대부분의 개념을 살펴봅니다.|페이지 라우팅, 레이아웃 설정, 데이터 페칭, 스트리밍, 배포등의 다양한 개념을 살펴봅니다', '한입 시리즈의 수강생 여러분|Next.js를 처음 시작하는 입문자 분들|최신 Next.js(15+) 버전으로 배워보고 싶으신 분|친절하고 디테일한 강의를 찾고 계신 분', '한 입 크기로 잘라먹는 Next.js(15+)', 'https://www.inflearn.com/course/%ED%95%9C%EC%9E%85-%ED%81%AC%EA%B8%B0-nextjs?attributionToken=ChIyOTYxMzkyNTM3MzQ1NDg0MDYQDRojcmVjb21tZW5kZV9yZWNvbW1lbmRlXzE3MDI1MjY0MzQwNjYiF3JlY29tbWVuZGVkLWZvci15b3UtY3ZyKAA6KPrx0RK08dESsvHREr7y0RKp8tES9_HREozy0RKP8tESu', 33880);
INSERT INTO lecture (lecture_id, image_url, instructor, goals, target, title, lecture_url, price) VALUES (3, 'https://cdn.inflearn.com/public/courses/334598/cover/c109f7d7-c67a-46ee-85a4-7a3a965f91af/334598.png?w=420', '마소캠퍼스', '빅데이터 이해와 분석 계획 수립 방법|필수 이론 및 요점 정리를 통한 완벽한 자격 검정 시험 준비|데이터 수집 및 저장 계획의 설계|유형별 최신 기출 복원 문제 풀이로 완성하는 자격증 합격 전략', '단기간에 빅데이터 분석 기사 자격증 취득을 목표로 하는 분|빅데이터 분석 분야에 자신이 없지만 시험 합격을 원하는 분|빅데이터 분석 기사 필기 시험에 불합격했던 분|IT업계로 입사/직무전환/리스킬을 꿈꾸는 분', '빅데이터분석기사 필기 올인원: 3주에 끝내는 완벽 대비', 'https://www.inflearn.com/course/%EB%B9%85%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B6%84%EC%84%9C%EA%B8%B0%EC%82%AC-%ED%95%84%EA%B8%B0-%EC%98%AC%EC%9D%B8%EC%9B%90-3%EC%A3%BC%EC%99%84%EC%84%B1?attributionToken=ChIyOTYxMzkyNTM3MzQ1NDg0MDYQDRojcmVjb21tZW5kZV9yZWNvbW1lb', 111650);
INSERT INTO lecture (lecture_id, image_url, instructor, goals, target, title, lecture_url, price) VALUES (4, 'https://cdn.inflearn.com/public/courses/334696/cover/4b003c11-90a1-48c5-b8f8-d85aad6bfdcd/334696.jpg?w=420', '써니라이더', '게임기획|서비스기획|pm|po|사업pm', '서비스기획자|게임기획자|사업pm|pm|po', 'PM,게임기획서 시스템기획 데이터테이블 PO 13주제 122개', 'https://www.inflearn.com/course/%EA%B2%8C%EC%9E%84-%EC%8B%9C%EC%8A%A4%ED%85%9C%EA%B8%B0%ED%9A%8D-%EB%8D%B0%EC%9D%B4%ED%84%B0%ED%85%8C%EC%9D%B4%EB%B8%94?attributionToken=ChIyOTYxMzkyNTM3MzQ1NDg0MDYQDRojcmVjb21tZW5kZV9yZWNvbW1lbmRlXzE3MDI1MjY0MzQwNjYiF3JlY2', 76230);
INSERT INTO lecture (lecture_id, image_url, instructor, goals, target, title, lecture_url, price) VALUES (5, 'https://cdn.inflearn.com/public/courses/334605/cover/d2c99c3e-dd29-410b-a916-341350c9a22d/334605.png?w=420', 'JSCODE 박재성', '스스로 프로젝트에 적용시킬 수 있는 조회 성능 최적화 방법|실무에서 자주 쓰는 Redis 활용 방법|Redis 기본 사용법|Redis의 캐싱 기능 활용 방법|부하 테스트를 활용한 성능 비교', 'IT 서비스 기업으로 취업을 희망하는 백엔드 개발자|차별성 있는 스펙을 만들고 싶은 취준생|Redis를 활용해 성능 개선을 해보고 싶으신 분|현업에서 조회 성능 개선 업무를 해야 하는 분|Redis를 입문하시는 분|대용량 트래픽 처리를 배우고 싶으신 분', '비전공자도 이해할 수 있는 Redis 입문/실전 (조회 성능 최적화편)', 'https://www.inflearn.com/course/%EB%B9%84%EC%A0%84%EA%B3%B5%EC%9E%90-redis-%EC%9E%85%EB%AC%B8-%EC%84%B1%EB%8A%A5-%EC%B5%9C%EC%A0%81%ED%99%94?attributionToken=ChIyOTYxMzkyNTM3MzQ1NDg0MDYQDRojcmVjb21tZW5kZV9yZWNvbW1lbmRlXzE3MDI1MjY0MzQwNjYiF3JlY29tbWVuZGVkL', 53900);
INSERT INTO lecture (lecture_id, image_url, instructor, goals, target, title, lecture_url, price) VALUES (6, 'https://cdn.inflearn.com/public/courses/333850/cover/e2cd825a-0bf8-4010-be8e-94d21da23025/333850.png?w=420', '알리 Ally', '코딩테스트에 필요한 파이썬 개념|코딩테스트에 필요한 자료구조 & 알고리즘|세계 대회 진출자가 알려주는 문제를 접근하는 법|실전 감각 향상을 위한 실제 카카오 코딩테스트 해설', '코딩테스트 공부를 막 시작하는 사람|코딩테스트 공부는 했는데, 문제만 보면 막히는 사람|코딩테스트 문제를 느낌이 아닌 논리적으로 풀고 싶은 사람|코딩테스트를 체계적으로 공부하고 싶은 사람', '세계 대회 진출자가 알려주는 코딩테스트 A to Z (with Python)', 'https://www.inflearn.com/course/%EC%84%B8%EA%B3%84%EB%8C%80%ED%9A%8C-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%8C%8C%EC%9D%B4%EC%8D%AC?attributionToken=ChIyOTYxMzkyNTM3MzQ1NDg0MDYQDRojcmVjb21tZW5kZV9yZWNvbW1lbmRlXzE3MDI1MjY0MzQwNjYiF3JlY29tbWVuZGV', 99000);
INSERT INTO lecture (lecture_id, image_url, instructor, goals, target, title, lecture_url, price) VALUES (7, 'https://cdn.inflearn.com/public/courses/333275/cover/09d37475-651e-46e4-93e2-a5d6fc96b998/333275.png?w=420', 'Rookiss', '언리얼 엔진 소스코드 분석|게임 엔진 분석', '언리얼 엔진 소스코드 분석에 도전하고 싶은 클라 개발자|언리얼 엔진 프로그래머 취준생', '[Rookiss University] Haker님의 UE5 소스코드 분석 시리즈 #1 (게임 프레임워크)', 'https://www.inflearn.com/course/unreal-%EC%86%8C%EC%8A%A4%EC%BD%94%EB%93%9C%EB%B6%84%EC%84%9D-1?attributionToken=ChIyOTYxMzkyNTM3MzQ1NDg0MDYQDRojcmVjb21tZW5kZV9yZWNvbW1lbmRlXzE3MDI1MjY0MzQwNjYiF3JlY29tbWVuZGVkLWZvci15b3UtY3ZyKAA6KPrx0RK08dESsvHREr7y0RKp8t', 231000);
INSERT INTO lecture (lecture_id, image_url, instructor, goals, target, title, lecture_url, price) VALUES (8, 'https://cdn.inflearn.com/public/courses/324082/cover/57af93de-1021-40b4-80d7-a0dfc17190cf/324082.png?w=420', '잔재미코딩 DaveLee', '파이썬 입문|크롤링 입문|데이터를 프로그래밍으로 다루는 기법|데이터 과학 입문 (데이터 수집 기술)|데이터를 다루기 위해 필요한 기술과 데이터 포맷(웹기술, JSON, XML등)|파이썬으로 엑셀을 다루는 기법|파이썬으로 OPEN API 사용하는 방법', '파이썬을 처음 접하는 분|크롤링을 처음 접하는 분|빅데이터를 처음 접하는 분|데이터 과학을 처음 접하는 분|데이터 분석을 위한 기본 기술을 익히고자 하시는 분|파이썬 기본기를 탄탄히 정리하고 싶은 분|크롤링과 파이썬으로 엑셀 파일 다루는 기능도 익히고 싶은 분', '파이썬입문과 크롤링기초 부트캠프 [파이썬, 웹, 데이터 이해 기본까지] (업데이트)', 'https://www.inflearn.com/course/python-crawling-basic?attributionToken=ChIyOTYxMzkyNTM3MzQ1NDg0MDYQDRojcmVjb21tZW5kZV9yZWNvbW1lbmRlXzE3MDI1MjY0MzQwNjYiF3JlY29tbWVuZGVkLWZvci15b3UtY3ZyKAA6KPrx0RK08dESsvHREr7y0RKp8tES9_HREozy0RKP8tESu_LREq3y0RI', 66000);

-- my_lecture
INSERT INTO my_lecture (id, lecture_id, member_id) VALUES (1, 1, 1);
INSERT INTO my_lecture (id, lecture_id, member_id) VALUES (2, 2, 1);
INSERT INTO my_lecture (id, lecture_id, member_id) VALUES (3, 3, 1);
INSERT INTO my_lecture (id, lecture_id, member_id) VALUES (4, 4, 1);
INSERT INTO my_lecture (id, lecture_id, member_id) VALUES (5, 5, 1);
INSERT INTO my_lecture (id, lecture_id, member_id) VALUES (6, 6, 1);
INSERT INTO my_lecture (id, lecture_id, member_id) VALUES (7, 7, 1);
INSERT INTO my_lecture (id, lecture_id, member_id) VALUES (8, 8, 1);
INSERT INTO my_lecture (id, lecture_id, member_id) VALUES (9, 9, 1);
INSERT INTO my_lecture (id, lecture_id, member_id) VALUES (10, 10, 1);
