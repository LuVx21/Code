#! /usr/bin/env python
# -*- coding: utf-8 -*-
# http://selfboot.cn/2014/08/12/python_how_to_use_trie_tree/

class Trie_tree():
    def __init__(self):
        # node = [father, child, keep_char, word_count]
        self._root = [None, [], None, 0]

    def insert(self, word):
        current_word = word
        current_node = self._root
        self._insert_operation_1(current_word, current_node)

    def _insert_operation_1(self, current_word, current_node):
        if current_word != "":
            first_char = current_word[0]
            child_node = current_node[1]
            is_in_child_node = False

            for node in child_node:
                if first_char == node[2]:
                    is_in_child_node = True
                    current_word = current_word[1:]
                    current_node = node
                    self._insert_operation_1(current_word, current_node)
                    break
                else:
                    continue

            if not is_in_child_node:
                self._insert_operation_2(current_word, current_node)

        else:
            current_node[3] += 1

    def _insert_operation_2(self, current_word, current_node):
        first_char = current_word[0]

        # creat a new node and insert it in the tree
        new_node = [None, [], None, 0]
        new_node[2] = first_char
        new_node[0] = current_node
        current_node[1].append(new_node)

        current_word = current_word[1:]
        if current_word != "":
            current_node = new_node
            self._insert_operation_2(current_word, current_node)

        else:
            new_node[3] += 1

    def find(self, word):
        current_word = word
        current_node = self._root
        return self._find_opration(current_word, current_node)

    def _find_opration(self, current_word, current_node):
        if current_word != "":
            first_char = current_word[0]
            child_node = current_node[1]

            if child_node == []:
                return 0

            is_in_child_node = False
            for node in child_node:
                if first_char == node[2]:
                    is_in_child_node = True
                    current_word = current_word[1:]
                    current_node = node
                    return self._find_opration(current_word, current_node)

                else:
                    continue

            if not is_in_child_node:
                return 0
        else:
            return current_node[3]

if __name__ == "__main__":
    import re
    demo_trie = Trie_tree()
    print "--------Build the tree--------"

    with open("article.txt", "r") as content:
        for line in content:
            for word in re.split(r"[\s\W]+", line):
                if word == "":
                    break
                if not word.isdigit():
                    demo_trie.insert(word.lower())
                else:
                    pass

    print "-------Count word test:-------"
    print "all      :", demo_trie.find("all")
    print "is       :", demo_trie.find("is")
    print "good     :", demo_trie.find("good")
    print "packages :", demo_trie.find("packages")