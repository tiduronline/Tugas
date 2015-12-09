#include <iostream>
#include <cstring>

using namespace std;

struct Node {
  char word;
  Node* next;
};


class LinkList {
private:
  Node* FirstNode;

public:

  LinkList(){
    FirstNode = NULL;
  }

  ~LinkList(){}

  void addNode(char word){
    Node* node = new Node();

    node->word = word;
    node->next = FirstNode;
    FirstNode = node;
  }

  void printNode(){

    while(FirstNode){
      cout << FirstNode->word ;
      FirstNode = FirstNode->next;
    }

  }
};


void printBanner(const char *name, LinkList list){

  cout << endl;
  cout << "NIM: 31337" << endl;
  cout << "Nama: " << name << endl;
  cout << "Tugas P10 - Program Linked List" << endl;
  cout << "=======================================" << endl;
  cout << "String awal: " << name << endl;
  cout << "Setelah link list: ";
  list.printNode();

  cout << endl << endl;
}


int main(void){

  LinkList list;
  const char* name = "tiduronline";
  int len = strlen(name);

  for(int i=0; i<len; i++) {
    list.addNode(*(name+i));
  }

  printBanner(name, list);

  return 0;
}
