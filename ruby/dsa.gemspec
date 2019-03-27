require "./lib/version"

Gem::Specification.new do |spec|
  spec.name = "dsa"
  spec.version = Dsa::VERSION
  spec.authors = ["Evgeny Mironenko"]
  spec.email = ["miron4dev@gmail.com"]

  spec.summary = "Data Structures and Algorithms"
  spec.homepage = "https://github.com/miron4dev/data-structures-and-algorithms/ruby"
  spec.license = "MIT"

  spec.require_paths = ["lib"]
end
