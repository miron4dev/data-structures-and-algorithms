require 'minitest/autorun'
require 'algorithms'

class PalindromeTest < Minitest::Test

  include Algorithms::Leetcode::String

  def setup
    @tested = Palindrome.new
  end

  def test_true_palindrome
    str = 'A.bcdE.fedcba'

    assert @tested.palindrome?(str)
  end

  def test_false_empty
    assert @tested.palindrome?('')
  end

  def test_false_not_palindrome
    str = 'not a palindrome'

    refute @tested.palindrome?(str)
  end
end
