module Algorithms::Leetcode::String

  #
  # Given two strings str1 and str2, write a function to determine if str1 is an anagram of str2.
  #
  class Anagram

    OFFSET = 'a'.ord

    def anagram?(str1, str2)
      return false if str1.length != str2.length

      freq = Array.new(26, 0)

      str1.each_byte {|c| freq[c - OFFSET] = freq[c - OFFSET] + 1}
      str2.each_byte {|c| freq[c - OFFSET] = freq[c - OFFSET] - 1}

      freq.all?(&:zero?)
    end
  end
end
