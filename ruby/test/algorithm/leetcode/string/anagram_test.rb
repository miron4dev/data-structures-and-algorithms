require 'minitest/autorun'
require 'algorithms'

class AnagramTest < Minitest::Test

  include Algorithms::Leetcode::String

  def setup
    @tested = Anagram.new
  end

  def test_true_anagram
    str1 = "abcdef"
    str2 = "dcfeba"

    assert(@tested.anagram?(str1, str2))
  end

  def test_false_lengths_not_equal
    str1 = "abcdef"
    str2 = "dcfed"

    refute(@tested.anagram?(str1, str2))
  end

  def test_false
    str1 = "abcdef"
    str2 = "dcfedz"

    refute(@tested.anagram?(str1, str2))
  end
end
