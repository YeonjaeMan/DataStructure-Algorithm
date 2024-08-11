## 8/11 일
- 문자열 안의 문자들이 고유한지 확인하기
  - UniqueString
- 두개의 문자열이 서로 치환(Permutation)인지 알아내기
  - Permutation
- 문자열안의 공백을 URL엔코딩하기
  - Encoding

## 8/10 토
- 해쉬테이블(Hash Table)에 대해 알아보고 구현하기
  - HashTable
- 자바의 ArrayList에 대해 알아보고 구현하기
  - ArrayList
- 자바의 StringBuilder에 대해 알아보고 구현하기
  - StringBuilder

## 8/9 금
- 순회결과로 원본트리 재현하기
  - BuildTree
- BST insertion/deletion
  - BinarySearchTree

## 8/8 목
- 트리에서 주어진 값을 합산으로 가지는 경로의 개수 찾기
  - CountPath

## 8/7 수
- 이진검색트리를 만드는 모든 배열 찾기
  - AllSequences
- 서브트리인지 확인하기
  - CheckSubTree
- 이진트리에서 랜덤노드가져오기
  - GetIthNode

## 8/6 화
- Tree에서 두노드의 첫번째 공통부모 찾기
  - FindCommonParent

## 8/4 일
- Graph에 명시된 관계에 따라 데이터 뽑아오기
  - Project

## 8/3 토
- 주어진 트리가 이진검색트리인지 확인하기
  - CheckBST : inorder 변형, 배열 공간 없는 방법, 최소값/최대값 범위 지정
- 이진검색트리에서 다음노드 찾기(inorder 사용)
  - FindNextNode

## 8/2 금
- Tree의 Balance 확인하기
  - BalanceCheckTree

## 8/1 목
- Graph에서 두지점의 경로찾기
  - SearchGraph
- 배열을 이진검색트리로 만들기
  - BinaryTree
- 이진트리를 레벨단위 리스트로 변형하기
  - BSTtoList

## 7/31 수
- Tree, Heap, Trie 정리
  - Tree.md
- Binary Tree의 3가지 순회방법 구현 (inorder, preorder, postorder)
  - Tree
- Graph 정리
  - Graph.md
- BFS, DFS 구현
  - Graph

## 7/30 화
- ArrayList를 사용한 멀티 스택
  - SetOfStack : 내부적으로는 스택이 나뉘어있지만, 겉으로는 확인할 수 없음
  - SetOfStack2 : popAt(), shiftLeft() 추가
- 두개의 Stack으로 Queue 만들기
  - MyQueue
- Stack 정렬하기
  - SortStack
- LinkedList로 Queue 구현하기
  - AnimalShelter

## 7/29 월
- 고정 길이 스택 구현
  - FixedMultiStacks
- 유동 길이 스택 구현
  - MultiStacks
- Stack의 작은값 찾기
  - StackWithMin : 스택에 작은값 같이 저장
  - StackWithMin2 : 또 다른 스택에 작은값 저장

## 7/28 일
- Stack 구현 (push, pop, peek, isEmpty)
- Queue 구현 (add, remove, peek, isEmpty)

## 7/26 금
- LinkedList 교차점 찾기
  - GetIntersection
- LinkedList 루프 찾기
  - FindLoop

## 7/25 목
- LinkedList Digit 합산 알고리즘
  - SumLists1 : 재귀 호출 사용
  - SumLists2 : 재귀 호출 사용
- LinkedList 회문(Palindrome) 찾기
  - Palindrome1 : 거꾸로 정렬해서 비교하기
  - Palindrome2 : 두 개의 포인터와 스택 사용 (토끼와 거북이)
  - Palindrome3 : 재귀 호출 사용

## 7/24 수
- 단방향 LinkedList 뒤부터 세기
  - KthToLast1 : 노드의 개수를 세고 처음으로 돌아와서 찾는 방법
  - KthToLast2 : 재귀 호출 사용
  - KthToLast3 : 두 개의 포인터 사용
- 단방향 LinkedList 중간 노드 삭제
  - DeleteNode : 삭제할 노드에 다음 노드를 복사하고, 다음 노드 삭제
- LinkedList 값에 따라 나누기
  - Partition1 : 두 줄로 세우기
  - Partition2 : 앞뒤로 붙이기

## 7/23 화
- 헤더가 없는 단방향 LinkedList 구현
  - Node + SinglyLinkedList
- 헤더가 있는 단방향 LinkedList 구현
  - LinkedList + LinkedListNode
- 정렬되어 있지 않은 LinkedList의 중복값 제거
  - LinkedList + RemoveDups
