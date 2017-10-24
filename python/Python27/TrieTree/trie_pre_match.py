#! /usr/bin/env python
# -*- coding: utf-8 -*-
# http://selfboot.cn/2014/08/12/python_how_to_use_trie_tree/

class Trie_tree():
    def __init__(self):
        # node = [father, child, keep_char, is_word]
        self._root = [None, [], None, False]

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
            current_node[3] = True

    def _insert_operation_2(self, current_word, current_node):
        first_char = current_word[0]

        # creat a new node and insert it in the tree
        new_node = [None, [], None, False]
        new_node[2] = first_char
        new_node[0] = current_node
        current_node[1].append(new_node)

        current_word = current_word[1:]
        if current_word != "":
            current_node = new_node
            self._insert_operation_2(current_word, current_node)

        else:
            new_node[3] = True

    def find(self, word):
        current_word = word
        current_node = self._root
        return self._find_opration(current_word, current_node)

    def _find_opration(self, current_word, current_node):
        if current_word != "":
            first_char = current_word[0]
            child_node = current_node[1]

            if child_node == []:
                return False

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
                return False
        else:
            return current_node[3]

    def delete(self, word):
        current_word = word
        current_node = self._root
        return self._delete_operation(current_word, current_node)

    def _delete_operation(self, current_word, current_node):
        if current_word != "":
            first_char = current_word[0]
            child_node = current_node[1]
            if child_node == []:
                return False

            is_in_child_node = False

            for node in child_node:
                if first_char == node[2]:
                    is_in_child_node = True
                    current_word = current_word[1:]
                    current_node = node
                    return self._delete_operation(current_word, current_node)

            if not is_in_child_node:
                return False
        else:
            if current_node[1] is not None:
                current_node[3] = False
            else:
                father_node = current_word[0]
                father_node[1].remove(current_node)

            return True

    def pre_match(self, pre_str):
        current_word = pre_str
        current_node = self._root
        return self._pre_match_op(current_word, current_node)

    def _pre_match_op(self, current_word, current_node):
        if current_word != "":
            first_char = current_word[0]
            child_node = current_node[1]
            if child_node == []:
                return None

            is_in_child_node = False
            for node in child_node:
                if first_char == node[2]:
                    is_in_child_node = True
                    current_word = current_word[1:]
                    current_node = node
                    return self._pre_match_op(current_word, current_node)
                else:
                    continue

            if not is_in_child_node:
                return None
        else:
            match_word = []

            # pre_str is already a word
            if current_node[3]:
                match_word.append("")

            self._pre_match_dfs("", current_node, match_word)
            return match_word

    def _pre_match_dfs(self, keep_char, current_node, match_word):
        child_node = current_node[1]
        for child in child_node:
            word = keep_char + child[2]
            if child[3]:
                match_word.append(word)
            else:
                pass

            self._pre_match_dfs(word, child, match_word)

        return match_word

if __name__ == "__main__":
    demo_trie = Trie_tree()
    print "--------Insert dict-------- "
    with open("words.txt", "r") as word_set:
        for line in word_set:
            for word in line.split():
                demo_trie.insert(word)

    pre_str = ""
    print "------Enter pre_str-------- "
    while(pre_str != EOFError):
        try:
            pre_str = raw_input("-> ")
            words = demo_trie.pre_match(pre_str)
            if words is None:
                print "No word start with ", pre_str
            else:
                for word in words:
                    print pre_str + word
                print "Totaly ", len(words), " words"
        except EOFError:
            print "Exit......"
            break