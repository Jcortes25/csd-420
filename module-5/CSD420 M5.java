def read_words_from_file(filename):
    with open(filename, 'r') as file:
        content = file.read()
        # Split into words, normalize case, strip punctuation if needed
        words = content.lower().split()
    return words

def get_unique_sorted_words(words):
    unique_words = sorted(set(words))
    return unique_words

def get_unique_sorted_words_desc(words):
    unique_words = sorted(set(words), reverse=True)
    return unique_words

def main():
    filename = 'collection_of_words.txt'
    words = read_words_from_file(filename)

    print("Original Words (lowercased):", words)

    unique_sorted = get_unique_sorted_words(words)
    print("\nNon-duplicate Words in Ascending Order:")
    print(unique_sorted)

    unique_sorted_desc = get_unique_sorted_words_desc(words)
    print("\nNon-duplicate Words in Descending Order:")
    print(unique_sorted_desc)

# ------------------ TEST CODE ------------------
def test_unique_word_sorting():
    test_words = ['apple', 'banana', 'orange', 'apple', 'grape', 'banana']
    expected_asc = ['apple', 'banana', 'grape', 'orange']
    expected_desc = ['orange', 'grape', 'banana', 'apple']

    assert get_unique_sorted_words(test_words) == expected_asc, "Ascending sort test failed!"
    assert get_unique_sorted_words_desc(test_words) == expected_desc, "Descending sort test failed!"
    print("\nTest cases passed successfully!")

if __name__ == '__main__':
    main()
    test_unique_word_sorting()
