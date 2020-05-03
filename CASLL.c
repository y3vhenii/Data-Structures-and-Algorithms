#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* self-referential structure */
struct Node {
    int *itms;          /* pointer to items inside the node */
    int contents;       /* total number of items in the node */
    int first;          /* next first item in the array */
    struct Node *next;  /* Pointer to the next array */
};

struct List {
    struct Node *head;
    struct Node *tail;
    int totalItems;     /* Total number of items in the list */
    int capacityPerNode;

};

struct List SLL_new(int itemsPerNode) {
    /* construct an empty list */
    struct List list;
    list.head = NULL;
    list.tail = NULL;
    list.capacityPerNode = itemsPerNode;
    list.totalItems = 0;
    return list;
}

int SLL_length(struct List *list) {
    /* return the number of items in the list */
    return list->totalItems;
}

int SLL_empty(struct List *list) {
    /* return true if the list contains no items */
    return list->head == NULL;
}

int SLL_pop(struct List *list) {
    /* remove and return the first item of the list */
    struct Node *node = list->head;
    int item = node->itms[++(node->first)]; /* get first item of the head */
    if(--(node->contents) == 0){            /* decrement since I assume the node is empty */
        list->head = list->head->next;      /* next node is head now */
        free(node->itms);
        free(node);
    }
    list->totalItems--;

    if (SLL_empty(list)) {
        list->tail = NULL;
    }
    return item;
}

void SLL_clear(struct List *list) {
    /* remove all the items from the list */
    while (!SLL_empty(list)) {
        SLL_pop(list);
    }
}

void SLL_push(struct List *list, int item) {
    /* insert the item at the front of the list */
    int j = list->capacityPerNode;
    if (SLL_empty(list) || list->head->contents >= j) {     /* if list is empty or head is full */
        struct Node *node = malloc(sizeof(struct Node));
        if (node != NULL) {                                 /* check if malloc occured properly for node */
            node->itms = calloc((size_t)j, sizeof(int));    /* allocate node capacity to store int's*/
            if (node->itms != NULL) {                       /* check if calloc occured properly for items */
                node->itms[j] = item;
                node->contents = 1;                     
                node->first = j - 1;                        /* next first pointer to be filled */
                node->next = list->head;
                if (SLL_empty(list)) {
                    list->tail = node;
                }
                list->head = node;
            }
        }
    }
    else {
        list->head->itms[list->head->first--] = item;       /*if head is not full yet, push the int in the head*/
        list->head->contents++;                             /* increment the total item count in head */
    }
    list->totalItems++;
}

void SLL_append(struct List *list, int item) {
    /* append the item to the end of the list */
    
    int j = list->capacityPerNode;      /* If the list is empty, push one node in front of the list */
    if (SLL_empty(list)) {
        SLL_push(list, item);
    }
    
    else {
        if(list->tail->contents < j){   /* if tail has more than enough space for another item */

            int k;
            for (k = 1; k < j+1; k++){                          /*move every item left by one space*/
                list->tail->itms[k-1] = list->tail->itms[k];
            }

            list ->tail ->itms[j] = item;                       /*update the last value of itms*/
            list ->tail ->first = list->tail->first -1;         /*move "first" one position left*/
            list ->tail ->contents++;                           /*increment tail node contents count*/
        }
        else { /*If tail is full, create new node and assign new value to it*/
            struct Node *node = malloc(sizeof(struct Node));
            if(node != NULL){
                node->itms=calloc(j, sizeof(int));
                if(node->itms != NULL) {
                    node->itms[j] = item;
                    node->contents = 1;
                    node->first = j - 1;
                    node->next = NULL;
                    list->tail->next = node;
                    list->tail = node;
                }
            }
        }
        list->totalItems++;
    }
}


double speedtest(int nodeCapacity, int items) {
    /* Returns the time for each speed test to main */
    clock_t t;
    struct Node *p;
    t = clock();
    struct List list = SLL_new(nodeCapacity);   /* instantiate a list */
    int i;      /* i is used in for loop */
    int k;      /* k is used in for loop */
    int j = 1;
    int val;                                    /* will hold every value during traversal */
    for(i=0; i<items; i++){                     /* Append items 1...2...3...4...5... */
        SLL_append(&list, j);
        j++;
    }
    for (p = list.head; p != NULL; p = p->next) {
        for(k = 0; k < sizeof(list.capacityPerNode) / sizeof(int); k++) {
            val = p->itms[k];
        }
    }
    SLL_clear(&list);
    t = clock() - t;
    double time_taken = ((double)t)/CLOCKS_PER_SEC; /* in seconds */
    return time_taken;
}
int main() {

        int quickerTime = 0;                                /* boolean value used in the while loop*/
        int itemsPerNode = 2;
        double timeForOneNode = speedtest(1, 20000000);     /*  measure time for node capacity of 1 and 20000000 items in the list*/
        double timeToBeat = timeForOneNode/2;               /* target time to beat*/

        while(quickerTime<1){
            double currCheckTime = speedtest(itemsPerNode, 20000000);
            if(currCheckTime<=timeToBeat){
                printf("The node capacity to be twice faster is: %d\n", itemsPerNode);
                quickerTime++;
            }
            else {
                itemsPerNode *= 2;
            }
        }
    return 0;
}